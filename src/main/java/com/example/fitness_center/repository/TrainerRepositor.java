package com.example.fitness_center.repository;

import com.example.fitness_center.entity.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainerRepositor extends MongoRepository<Trainer, Long> {
}
