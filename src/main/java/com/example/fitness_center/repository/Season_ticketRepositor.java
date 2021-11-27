package com.example.fitness_center.repository;

import com.example.fitness_center.entity.Season_ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Season_ticketRepositor extends MongoRepository<Season_ticket, Long> {
}
