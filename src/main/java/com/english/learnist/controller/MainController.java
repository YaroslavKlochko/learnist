package com.english.learnist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/main")
public class MainController {

    @GetMapping(value = {"/index", "/"})
    public String getMainPage() {
        return "index";
    }
}
