package com.learnist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/task")
public class TaskController {

    @GetMapping(value = "/list")
    public String getTaskList(){
        return "task/list";
    }
}
