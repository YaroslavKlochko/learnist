package com.learnist.database.service;

import com.learnist.database.repository.PasswordResetTokenRepository;
import com.learnist.domain.User;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class TokenServiceTest {

    public final Long userId = 1L;
    public final String token = "4204725874957844";
    public final String email = "test@gmail.com";

    private UserService userService = mock(UserService.class);
    private PasswordResetTokenRepository passwordResetTokenRepository = mock(PasswordResetTokenRepository.class);

    @Test
    public void shouldReturnGeneratedToken(){
        User user = new User();

       //when(generateToken(email)).thenReturn(passwordResetToken);
    }

    @Test
    public void shouldReturnTrueTokenExist(){
      //  when(passwordResetTokenRepository.findPasswordResetTokenByToken(token)).thenReturn(of(passwordResetToken));
    }

    @Test
    public void deleteToken(){
        passwordResetTokenRepository.deleteByUserId(userId); // тут ведь ничего возвращать не нужно
    }
}
