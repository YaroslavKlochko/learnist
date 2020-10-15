package com.learnist.controller;

import com.learnist.database.service.UserService;
import com.learnist.domain.User;
import com.learnist.domain.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@Controller
@RequestMapping(value = "user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/add")
    public String getUserPage() {
        return "user";
    }

    @PostMapping(value = "/add")
    public String addUserAccount(@ModelAttribute("user") UserDTO user) {
        userService.addUser(user);
        return "redirect:/user/add?success";

    }
}
