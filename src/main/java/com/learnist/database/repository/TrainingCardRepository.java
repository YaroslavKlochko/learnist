package com.learnist.database.repository;

import com.learnist.domain.TrainingCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingCardRepository extends JpaRepository<TrainingCard, Long> {
}
