package com.learnist.controller;

import com.learnist.database.service.UserService;
import com.learnist.domain.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "user")
public class UserController {

    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/add")
    public String getUserPage() {
        return "user";
    }

    @PostMapping(value = "/add")
    public String addUserAccount(@ModelAttribute("user") final UserDTO user) {
        userService.addUser(user);
        return "redirect:/user/add?success";
    }
}
