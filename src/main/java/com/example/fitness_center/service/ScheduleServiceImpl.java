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
        schedules.add(new Schedule(1L,"Avanafil","Psychoactive substance, CNS stimulant. In terms of its pharmacological properties, it is almost identical to amphetamine. The period of action is 2-4 hours.",  5000.0, "C9H12FN"));
        schedules.add(new Schedule(2L,"Zaleplon","psychoactive substance, CNS stimulant. In terms of its pharmacological properties, it is almost identical to amphetamine. The period of action is 2-4 hours.",  45000.0, "C9H12FN"));
        schedules.add(new Schedule(3L,"Daratumumab","psychoactive substance, CNS stimulant. In terms of its pharmacological properties, it is almost identical to amphetamine. The period of action is 2-4 hours.",  7000.0, "C9H12FN"));
        schedules.add(new Schedule(4L,"Agen","psychoactive substance, CNS stimulant. In terms of its pharmacological properties, it is almost identical to amphetamine. The period of action is 2-4 hours.",  3000.0, "C9H12FN"));
        schedules.add(new Schedule(5L,"Dasabuvir","psychoactive substance, CNS stimulant. In terms of its pharmacological properties, it is almost identical to amphetamine. The period of action is 2-4 hours.",  2000.0, "C9H12FN"));
        schedules.add(new Schedule(6L,"Zantac","psychoactive substance, CNS stimulant. In terms of its pharmacological properties, it is almost identical to amphetamine. The period of action is 2-4 hours.",  5000.0, "C9H12FN"));
        schedules.add(new Schedule(7L,"Avastin","psychoactive substance, CNS stimulant. In terms of its pharmacological properties, it is almost identical to amphetamine. The period of action is 2-4 hours.",  6000.0, "C9H12FN"));
        schedules.add(new Schedule(8L,"Daunorubicin","psychoactive substance, CNS stimulant. In terms of its pharmacological properties, it is almost identical to amphetamine. The period of action is 2-4 hours.",  8000.0, "C9H12FN"));
        scheduleRepositor.saveAll(schedules);
    }
}
