package com.learnist.controller;

import com.learnist.database.service.TrainingCardService;
import com.learnist.domain.TrainingCard;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "dictionary/vocabulary")
public class VocabularyController {

    private static final String TITLE = "title";
    private final TrainingCardService trainingCardService;

    public VocabularyController(final TrainingCardService trainingCardService) {
        this.trainingCardService = trainingCardService;
    }

    @GetMapping(value = "/my-list")
    public String getMyVocabularyList(final Model model) {
        List<TrainingCard> trainingCardList = trainingCardService.getTrainingCardsList();
        model.addAttribute(TITLE, "Vocabulary | Learnist");
        model.addAttribute("trainingCards", trainingCardList);
        return "dictionary/vocabulary/my";
    }
}
