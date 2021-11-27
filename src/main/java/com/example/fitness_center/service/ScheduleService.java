package com.example.fitness_center.service;

import com.example.fitness_center.entity.Schedule;

import java.util.List;

public interface ScheduleService {
    List<Schedule> allSchedule();
    List<Schedule> scheduleGetList(Long id);
}
