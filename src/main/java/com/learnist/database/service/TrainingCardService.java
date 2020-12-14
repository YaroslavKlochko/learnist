package com.learnist.database.service;

import com.learnist.database.repository.TrainingCardRepository;
import com.learnist.domain.TrainingCard;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingCardService {

    private final TrainingCardRepository trainingCardRepository;

    public TrainingCardService(final TrainingCardRepository trainingCardRepository) {
        this.trainingCardRepository = trainingCardRepository;
    }

    public List<TrainingCard> getTrainingCardsList(){
        return trainingCardRepository.findAll();
    }
}
