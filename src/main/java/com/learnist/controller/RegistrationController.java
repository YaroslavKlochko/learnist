package com.learnist.controller;

import com.learnist.database.service.UserService;
import com.learnist.domain.UserDTO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/registration")
    public String getRegistrationPage() {
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String registerAccount(@ModelAttribute("user") final UserDTO user, final HttpServletRequest request) {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SecurityContextHolder.getContext().setAuthentication(authentication);
        request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
        userService.addUser(user);
        return "redirect:/registration?success";
    }
}