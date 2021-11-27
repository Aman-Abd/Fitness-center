package com.example.fitness_center.service;

import com.example.fitness_center.entity.Season_ticket;
import com.example.fitness_center.repository.Season_ticketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class Season_ticketServiceImpl implements Season_ticketService {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private Season_ticketRepository season_ticketRepository;

    @Override
    public List<Season_ticket> allSeason_tickets() {
        return season_ticketRepository.findAll();
    }

    @Override
    public List<Season_ticket> seasonGetList(Long id) {
        return em.createQuery("SELECT s FROM Season_ticket s WHERE s.season_id > :paramId", Season_ticket.class)
                .setParameter("paramId", id).getResultList();
    }
}
