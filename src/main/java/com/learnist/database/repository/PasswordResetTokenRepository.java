package com.learnist.database.repository;

import com.learnist.domain.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {
    Optional<PasswordResetToken> findPasswordResetTokenByToken(final String token);

    void deleteByUserId(final Long userId);

    PasswordResetToken findTokenByUserId(final Long userId);
}
