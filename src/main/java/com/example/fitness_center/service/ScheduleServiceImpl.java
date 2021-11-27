package com.example.fitness_center.service;

import com.example.fitness_center.entity.Schedule;
import com.example.fitness_center.entity.User;
import com.example.fitness_center.repository.ScheduleRepositor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService{
    @PersistenceContext
    private EntityManager em;

    private final ScheduleRepositor scheduleRepositor;

    public ScheduleServiceImpl(ScheduleRepositor scheduleRepositor) {
        this.scheduleRepositor = scheduleRepositor;
    }


    @Override
    public List<Schedule> allSchedule() {
        return scheduleRepositor.findAll();
    }

    @Override
    public List<Schedule> scheduleGetList(Long id) {
        List<Schedule> schedules = scheduleRepositor.findAll();
        List<Schedule> result = new ArrayList<Schedule>();

        for(Schedule s : schedules){
            if(s.getSchedule_id().equals(id))
                result.add(s);
        }
        return result;
    }

    @PostConstruct
    private void InitializeUser(){
        List<Schedule> schedules = new ArrayList<>();
        schedules.add(new Schedule(1L,"yoga","Tue/Fri 14:00",  5000.0, "John"));
        schedules.add(new Schedule(2L,"hip-hop","Tue/Fri 14:00",  45000.0, "Jack"));
        schedules.add(new Schedule(3L,"cycle","Tue/Fri 14:00",  7000.0, "Marta"));
        schedules.add(new Schedule(4L,"box","Tue/Fri 14:00",  3000.0, "Elizabet"));
        schedules.add(new Schedule(5L,"zumba","Tue/Fri 14:00",  2000.0, "Roy"));
        schedules.add(new Schedule(6L,"karate","Tue/Fri 14:00",  5000.0, "Rey"));
        schedules.add(new Schedule(7L,"gym","Tue/Fri 14:00",  6000.0, "Michael"));
        schedules.add(new Schedule(8L,"crossfit","Tue/Fri 14:00",  8000.0, "Lara"));
        scheduleRepositor.saveAll(schedules);
    }
}
