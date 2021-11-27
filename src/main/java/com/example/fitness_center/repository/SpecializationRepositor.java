package com.example.fitness_center.repository;

import com.example.fitness_center.entity.Specialization;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpecializationRepositor extends MongoRepository<Specialization, Long> {
}
