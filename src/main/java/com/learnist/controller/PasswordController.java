package com.learnist.controller;

import com.learnist.database.service.UserService;
import com.learnist.domain.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PasswordController {

    private final UserService userService;

    public PasswordController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/forgetPassword")
    public String getForgetPasswordPage() {
        return "forgetPassword";
    }

    @PostMapping(value = "/forgetPassword")
    public String getForgetPasswordPage(@ModelAttribute("email") final UserDTO user) {
        System.out.println(user.getEmail());
        return "forgetPassword";
    }
}
