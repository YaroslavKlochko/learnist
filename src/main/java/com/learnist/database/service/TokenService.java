package com.learnist.database.service;

import com.learnist.database.repository.PasswordResetTokenRepository;
import com.learnist.domain.PasswordResetToken;
import com.learnist.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final UserService userService;
    private final PasswordResetTokenRepository passwordResetTokenRepository;

    public PasswordResetToken generateToken(final String email) {
        final User user = userService.findUserByEmail(email);
        final PasswordResetToken token = new PasswordResetToken();
        token.setToken(UUID.randomUUID().toString());
        token.setUser(user);
        return passwordResetTokenRepository.save(token);
    }

    public PasswordResetToken tokenExists(final String token) {
        return passwordResetTokenRepository.findPasswordResetTokenByToken(token).orElse(null);
    }

    public Boolean validateTokenExpiryDate(final Long userId) {
        final PasswordResetToken token = passwordResetTokenRepository.findTokenByUserId(userId);
        final LocalDateTime expiryDateToken = token.getExpiryDate().plusHours(24);
        return token.getExpiryDate().isBefore(expiryDateToken);
    }

    @Transactional
    @Modifying
    public void deleteToken(final Long userId) {
        passwordResetTokenRepository.deleteByUserId(userId);
    }
}
