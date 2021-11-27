package com.example.fitness_center.service;

import com.example.fitness_center.entity.Season_ticket;
import com.example.fitness_center.entity.Trainer;
import com.example.fitness_center.repository.TrainerRepositor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService{
    @PersistenceContext
    private EntityManager em;

    private final TrainerRepositor trainerRepositor;

    public TrainerServiceImpl(TrainerRepositor trainerRepositor) {
        this.trainerRepositor = trainerRepositor;
    }

    @Override
    public List<Trainer> allTrainers() {
        return trainerRepositor.findAll();
    }

    @Override
    public List<Trainer> trainerGetList(Long id) {
        List<Trainer> trainers = trainerRepositor.findAll();
        List<Trainer> result = new ArrayList<Trainer>();

        for(Trainer s : trainers){
            if(s.getTrainer_id().equals(id))
                result.add(s);
        }
        return result;
    }

    @PostConstruct
    private void InitializeUser(){
        List<Trainer> trainers = new ArrayList<>();

        trainers.add(new Trainer(1L,"Lara", "123456789", "box", null, null));
        trainers.add(new Trainer(2L,"John", "123456789", "Yoga", null, null));
        trainerRepositor.saveAll(trainers);
    }

}

