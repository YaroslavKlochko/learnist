package com.learnist.database.service;

import com.learnist.database.repository.UserRepository;
import com.learnist.domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import static java.lang.Boolean.TRUE;

@Service
public final class AdminDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public AdminDetailsService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public final UserDetails loadUserByUsername(final String login) {
        final User user = userRepository.findByUsername(login);

        return new User(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                TRUE, TRUE, TRUE, TRUE);
    }
}
