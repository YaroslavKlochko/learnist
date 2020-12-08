package com.learnist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/training")
public class TrainingController {

    @GetMapping(value = "/list")
    public String getTrainingList(){
        return "trainings/list";
    }
}
