package com.learnist.database.service;

import com.learnist.database.repository.UserRepository;
import com.learnist.domain.User;
import com.learnist.exception.UserAlreadyExistsException;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.nonNull;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
