package com.learnist.config;

import com.learnist.database.repository.UserRepository;
import com.learnist.database.service.AdminDetailsService;
import com.learnist.database.service.CustomLoginFailureHandler;
import com.learnist.database.service.CustomLoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

import static java.lang.Boolean.TRUE;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserRepository userRepository;
    private final DataSource dataSource;

    public WebSecurityConfig(final UserRepository userRepository, final DataSource dataSource) {
        this.userRepository = userRepository;
        this.dataSource = dataSource;
    }


    @Autowired
    private CustomLoginFailureHandler loginFailureHandler;
    @Autowired
    private CustomLoginSuccessHandler loginSuccessHandler;

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/assets/**", "/webjars/**", "/resources/**").permitAll()
                .antMatchers("/", "/welcome", "/registration","/login-error", "/forgetPassword", "/reset-password/**").permitAll()
                .anyRequest().authenticated()

                .and()
                .oauth2Login().loginPage("/login")
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/j_spring_security_check")
                .usernameParameter("email")
//
                .permitAll()
                .failureHandler(loginFailureHandler)
                .successHandler(loginSuccessHandler)

                .and()
                .logout()
                .logoutUrl("/perform_logout")
                .invalidateHttpSession(TRUE)
                .deleteCookies("JSESSIONID")
                .clearAuthentication(TRUE)
                .logoutSuccessUrl("/login")

                .and()
                .rememberMe()
                .key("superSecretKey")
                .tokenValiditySeconds(84600)
                .tokenRepository(tokenRepository());
    }

    @Bean
    public PersistentTokenRepository tokenRepository() {
        JdbcTokenRepositoryImpl token = new JdbcTokenRepositoryImpl();
        token.setDataSource(dataSource);
        return token;
    }

    @Bean
    SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }
    @Autowired
    public void configureGlobal(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(getUserDetailsService()).passwordEncoder(passwordEncoder());
    }

    @Bean(name = "userDetailsService")
    public AdminDetailsService getUserDetailsService() {
        return new AdminDetailsService(userRepository);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }
}
