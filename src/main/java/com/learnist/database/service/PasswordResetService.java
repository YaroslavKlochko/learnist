package com.learnist.database.service;

import com.learnist.database.repository.PasswordResetTokenRepository;
import com.learnist.domain.PasswordResetToken;
import com.learnist.domain.User;
import com.learnist.exception.UserEmailDoesntExistException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static java.lang.String.format;

@Slf4j
@Service
@RequiredArgsConstructor
public class PasswordResetService {

    private final TokenService tokenService;
    private final UserService userService;
    private final PasswordResetTokenRepository passwordResetTokenRepository;
    private final NotificationService notificationService;

    public boolean validateUserEmail(final String email) {
        try {
            userService.checkIfUserExistsByEmail(email);
            final PasswordResetToken generatedToken = tokenService.generateToken(email);
            final String link = generatePasswordResetLinkForUser(generatedToken);
            notificationService.sendMessage(email, link);
            return true;
        } catch (UserEmailDoesntExistException e) {
            log.error("user with this email already exists Error trace: {}", e.getMessage());
        }
        return false;
    }

    private String generatePasswordResetLinkForUser(final PasswordResetToken generatedToken) {
        return format("http://localhost:8080/reset-password/%s", generatedToken.getToken());
    }

    public void changePassword(final Long userId, final String newPassword) {
        final User user = userService.findUserById(userId);
        final PasswordResetToken token = passwordResetTokenRepository.findTokenByUserId(userId);
        if (tokenService.validateTokenExpiryDate(userId)) {
            user.setPassword(new BCryptPasswordEncoder(10).encode(newPassword));
            userService.save(user);
            tokenService.deleteToken(userId);
        } else {
            token.setExpiryDate(LocalDateTime.now().plusHours(24));
            passwordResetTokenRepository.save(token);
            tokenService.generateToken(user.getEmail());
            final String link = generatePasswordResetLinkForUser(token);
            notificationService.sendMessage(user.getEmail(), link);
        }
    }
}
