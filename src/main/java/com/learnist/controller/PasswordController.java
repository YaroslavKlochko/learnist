package com.learnist.controller;

import com.learnist.database.service.PasswordResetService;
import com.learnist.database.service.TokenService;
import com.learnist.domain.PasswordResetToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

import static java.util.Objects.nonNull;

@Controller
@RequiredArgsConstructor
public class PasswordController {

    private final PasswordResetService passwordResetService;
    private final TokenService tokenService;

    @GetMapping(value = "/forgetPassword")
    public String getForgetPasswordPage() {
        return "forgetPassword";
    }

    @PostMapping(value = "/forgetPassword")
    public String getForgetPasswordPage(@ModelAttribute("email") final String email) {
        if (!passwordResetService.validateUserEmail(email)) {
            return "redirect:/forgetPassword?failure";
        } else {
            return "redirect:/forgetPassword?success";
        }
    }

    @GetMapping(value = "/reset-password/{token}")
    public String getResetPasswordPage(@PathVariable final String token, final Model model) {

        final PasswordResetToken passwordResetToken = tokenService.tokenExists(token);
        if (nonNull(passwordResetToken)) {
            model.addAttribute("userId", passwordResetToken.getUserId());
            return "resetPassword";
        } else {
            return "error";
        }
    }

    @PostMapping(value = "/reset-password")
    public String getResetPasswordPage(
            final @RequestParam("userId") Long userId,
            final @RequestParam("password") String password) {
        passwordResetService.changePassword(userId, password);
        return "login";
    }
}
