package com.learnist.database.service;

import com.learnist.config.WebSecurityConfig;
import com.learnist.database.repository.UserRepository;
import com.learnist.domain.Role;
import com.learnist.domain.User;
import com.learnist.domain.UserDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static java.lang.Boolean.TRUE;

@Service
@RequiredArgsConstructor
public class UserService {

    private final WebSecurityConfig webSecurityConfig;
    private final UserRepository userRepository;
    private final RoleService roleService;

    Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(final WebSecurityConfig webSecurityConfig, final UserRepository userRepository, final RoleService roleService) {
        this.webSecurityConfig = webSecurityConfig;
        this.userRepository = userRepository;
        this.roleService = roleService;
    }

    public void addUser(final UserDTO user) {
        logger.debug("Trying to add user: {}",user.getUsername());
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(webSecurityConfig.passwordEncoder().encode(user.getPassword()));
        newUser.setAccountNonExpired(TRUE);
        newUser.setAccountNonLocked(TRUE);
        newUser.setCredentialsNonExpired(TRUE);
        newUser.setEnabled(TRUE);
        final Role roleUser = roleService.findRoleByName("USER");
        newUser.getRoles().add(roleUser);
        userRepository.save(newUser);
        logger.debug("User with username: {} has been successfully added", user.getUsername());
    }
}
