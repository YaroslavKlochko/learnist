package com.learnist.domain;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UserAuth extends org.springframework.security.core.userdetails.User {
    private final String username;
    private final String password;
    private final String email;

    public UserAuth(final String username,
                    final String password,
                    final String email,
                    final Collection<? extends GrantedAuthority> authorities, String email1) {
        super(username, password, authorities);
        this.username = username;
        this.password = password;
        this.email = email1;
    }

    public UserAuth(final String username,
                    final String password,
                    final String email,
                    final boolean enabled,
                    final boolean accountNonExpired,
                    final boolean credentialsNonExpired,
                    final boolean accountNonLocked,
                    final Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
