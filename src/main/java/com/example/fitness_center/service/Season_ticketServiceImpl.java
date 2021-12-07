package com.example.fitness_center.service;

import com.example.fitness_center.entity.Schedule;
import com.example.fitness_center.entity.Season_ticket;
import com.example.fitness_center.repository.Season_ticketRepositor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
public class Season_ticketServiceImpl implements Season_ticketService {
    @PersistenceContext
    private EntityManager em;

    private final Season_ticketRepositor season_ticketRepositor;

    public Season_ticketServiceImpl(Season_ticketRepositor season_ticketRepositor) {
        this.season_ticketRepositor = season_ticketRepositor;
    }


    @Override
    public List<Season_ticket> allSeason_tickets() {
        return season_ticketRepositor.findAll();
    }

    @Override
    public List<Season_ticket> seasonGetList(Long id) {
        List<Season_ticket> season_tickets = season_ticketRepositor.findAll();
        List<Season_ticket> result = new ArrayList<Season_ticket>();

        for(Season_ticket s : season_tickets){
            if(s.getSeason_id().equals(id))
                result.add(s);
        }
        return result;
    }

    @PostConstruct
    private void InitializeUser(){
        List<Season_ticket> season_tickets = new ArrayList<>();
        season_tickets.add(new Season_ticket(1L, "Lura (Levomepam)", 100.0, null));
        season_tickets.add(new Season_ticket(2L, "John (Novoposit)", 200.0, null));
        season_tickets.add(new Season_ticket(3L, "Rosa (Angisept)", 250.0, null));

        season_ticketRepositor.saveAll(season_tickets);
    }



}
