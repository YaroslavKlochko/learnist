package com.learnist.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @GetMapping(value = "/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/login-error")
    public String getLoginErrorPage(Model model) {
        model.addAttribute("loginError", true);
        return "error";
    }

    @GetMapping(value = "/perform_logout")
    public final String getLogoutPage() {
        return "login";
    }

    @PostMapping(value = "/perform_logout")
    public final String getLogoutPage(final HttpServletRequest request, final HttpServletResponse response) {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
            return "login";
        }
        return "error";
    }
}
