package com.learnist.database.service;

import com.learnist.database.repository.UserRepository;
import com.learnist.domain.LearnistUserDetails;
import com.learnist.domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public AdminDetailsService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(final String login) {
        final User user = userRepository.findUserByEmail(login);
        return new LearnistUserDetails(user);
    }
}
