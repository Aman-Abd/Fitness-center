package com.example.fitness_center.repository;
import com.example.fitness_center.entity.Schedule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepositor extends MongoRepository<Schedule, Long> {
}
