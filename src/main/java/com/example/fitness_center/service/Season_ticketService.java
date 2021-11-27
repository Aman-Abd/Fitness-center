package com.example.fitness_center.service;

import com.example.fitness_center.entity.Season_ticket;

import java.util.List;

public interface Season_ticketService {
    List<Season_ticket> allSeason_tickets();
    List<Season_ticket> seasonGetList(Long id);
}
