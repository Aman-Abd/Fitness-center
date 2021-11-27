package com.example.fitness_center.repository;

import com.example.fitness_center.entity.Schedule;
import com.example.fitness_center.entity.Season_ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
