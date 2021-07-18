package com.learnist.database.service;

import com.learnist.config.WebSecurityConfig;
import com.learnist.database.repository.UserRepository;
import com.learnist.domain.Role;
import com.learnist.domain.User;
import com.learnist.domain.UserDTO;
import com.learnist.exception.UserEmailDoesntExistException;
import com.learnist.exception.UserIdDoesntExistException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

import static java.util.Objects.nonNull;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final WebSecurityConfig webSecurityConfig;
    private final UserRepository userRepository;
    private final RoleService roleService;


   public static final int MAX_FAILED_ATTEMPTS = 3;

    private static final long LOCK_TIME_DURATION = 2 * 60 * 60 * 1000;

    public void increaseFailedAttempts(final User user) {
        int newFailAttempts = user.getFailedAttempt() + 1;
        userRepository.updateFailedAttempts(newFailAttempts, user.getEmail());
    }

    public void resetFailedAttempts(String email) {
        userRepository.updateFailedAttempts(0, email);
    }

    public void lock(final User user) {
        user.setAccountNonLocked(false);
        user.setLockTime(new Date());

        userRepository.save(user);
    }

    @Transactional
        public boolean unlockWhenTimeExpired(final User user) {
            long lockTimeInMillis = user.getLockTime().getTime();
            long currentTimeInMillis = System.currentTimeMillis();

            if (lockTimeInMillis + LOCK_TIME_DURATION < currentTimeInMillis) {
                user.setAccountNonLocked(true);
                user.setLockTime(null);
                user.setFailedAttempt(0);

                userRepository.save(user);

                return true;
            }
            return false;
        }

    public void addUser(final UserDTO user) {
        log.debug("Trying to add user: {}", user.getUsername());
        final User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(webSecurityConfig.passwordEncoder().encode(user.getPassword()));
        final Role roleUser = roleService.findRoleByName("ROLE_USER");
        newUser.getRoles().add(roleUser);
        userRepository.save(newUser);
        log.debug("User with username: {} has been successfully added", user.getUsername());
    }

    public User findUserByEmail(final String email) {
        return userRepository.findUserByEmail(email);
    }

    public User findUserByUsername(final String username) {
        return userRepository.findByUsername(username);
    }

    public User findUserById(final Long id) {
        return userRepository.findUserById(id);
    }

    public void checkUserAvailability(final Long id, final Boolean enabled) {
        try {
            final User user = userRepository.findById(id).orElseThrow(() -> new UserIdDoesntExistException(id));
            user.setEnabled(enabled);
            userRepository.save(user);
        } catch (final UserIdDoesntExistException ex) {
            log.error("Error: {} during the attempt to disable user with id: {}", ex.getMessage(), id);
        }
    }

    public Boolean checkIfUserExistsByEmail(final String email) throws UserEmailDoesntExistException {
        if (nonNull(userRepository.findUserByEmail(email))) {
            return true;
        } else {
            throw new UserEmailDoesntExistException(email);
        }
    }

    public void save(final User user) {
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
