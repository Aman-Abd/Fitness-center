package com.example.fitness_center.service;

import com.example.fitness_center.entity.Schedule;
import com.example.fitness_center.repository.ScheduleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService{
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public List<Schedule> allSchedule() {
        return scheduleRepository.findAll();
    }

    @Override
    public List<Schedule> scheduleGetList(Long id) {
        return em.createQuery("SELECT s FROM Schedule s WHERE s.schedule_id > :paramId", Schedule.class)
                .setParameter("paramId", id).getResultList();
    }
}
