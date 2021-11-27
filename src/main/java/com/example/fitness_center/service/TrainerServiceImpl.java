package com.example.fitness_center.service;

import com.example.fitness_center.entity.Season_ticket;
import com.example.fitness_center.entity.Trainer;
import com.example.fitness_center.repository.Season_ticketRepository;
import com.example.fitness_center.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService{
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private TrainerRepository trainerRepository;

    @Override
    public List<Trainer> allTrainers() {
        return trainerRepository.findAll();
    }

    @Override
    public List<Trainer> trainerGetList(Long id) {
        return em.createQuery("SELECT t FROM Trainer t WHERE t.trainer_id > :paramId", Trainer.class)
                .setParameter("paramId", id).getResultList();
    }
}

