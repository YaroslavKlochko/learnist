package com.learnist.controller;

import com.learnist.database.service.UserService;
import com.learnist.domain.User;
import com.learnist.domain.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "user")
public class UserController {

    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/add")
    public String getUserPage() {
        return "users/user";
    }

    @PostMapping(value = "/add")
    public String addUserAccount(@ModelAttribute("user") final UserDTO user) {
        userService.addUser(user);
        return "redirect:/users/user/add?success";
    }

    @GetMapping(value = "/list")
    public String getUserList(final Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("users", userList);
        return "users/list";
    }

    @GetMapping(value = "/disable/{id}")
    public String disableUser(@PathVariable final Long id) {
        userService.checkUserAvailability(id, Boolean.FALSE);
        return "redirect:/user/list";
    }

    @GetMapping(value = "/enable/{id}")
    public String enableUser(@PathVariable final Long id) {
        userService.checkUserAvailability(id, Boolean.TRUE);
        return "redirect:/user/list";
    }
}
