package com.learnist.database.service;

import com.learnist.config.WebSecurityConfig;
import com.learnist.database.repository.UserRepository;
import com.learnist.domain.Role;
import com.learnist.domain.User;
import com.learnist.domain.UserDTO;
import com.learnist.exception.UserDoesntExistException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static java.lang.Boolean.TRUE;
import static java.util.Objects.nonNull;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final WebSecurityConfig webSecurityConfig;
    private final UserRepository userRepository;
    private final RoleService roleService;

    public void addUser(final UserDTO user) {
        log.debug("Trying to add user: {}", user.getUsername());
        final User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(webSecurityConfig.passwordEncoder().encode(user.getPassword()));
        newUser.setAccountNonExpired(TRUE);
        newUser.setAccountNonLocked(TRUE);
        newUser.setCredentialsNonExpired(TRUE);
        newUser.setEnabled(TRUE);
        final Role roleUser = roleService.findRoleByName("USER");
        newUser.getRoles().add(roleUser);
        userRepository.save(newUser);
        log.debug("User with username: {} has been successfully added", user.getUsername());
    }

    public User findUserByEmail(final String email) {
        return userRepository.findUserByEmail(email);
    }

    public User findUserById(final Long id) {
        return userRepository.findUserById(id);
    }

    public Boolean checkIfUserExistsByEmail(final String email) throws UserDoesntExistException {
        if (nonNull(userRepository.findUserByEmail(email))) {
            return true;
        } else {
            throw new UserDoesntExistException(email);
        }
    }

    public void save(final User user) {
        userRepository.save(user);
    }
}
