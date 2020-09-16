package com.learnist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value = "/main")
    public String getMainPage() {
        return "main";
    }
}
