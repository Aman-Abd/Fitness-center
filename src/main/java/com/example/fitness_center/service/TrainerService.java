package com.example.fitness_center.service;

import com.example.fitness_center.entity.Trainer;

import java.util.List;

public interface TrainerService {
    List<Trainer> allTrainers();
    List<Trainer> trainerGetList(Long id);
}
