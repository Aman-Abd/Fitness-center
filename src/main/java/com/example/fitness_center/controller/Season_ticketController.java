package com.example.fitness_center.controller;

import com.example.fitness_center.service.Season_ticketService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@Api(value = "Season_ticket Controller class", description = "This class allows to interact with Season_ticket object")
public class Season_ticketController {
    @Autowired
    private Season_ticketService season_ticketService;

    @GetMapping("/season_ticket")
    public String seasonList(Model model) {
        model.addAttribute("allSeasons_tickets", season_ticketService.allSeason_tickets());
        return "season_ticket";
    }

    @GetMapping("/season_ticket/gt/{seasonId}")
    public String  gtSeason_ticket(@PathVariable("seasonId") Long seasonId, Model model) {
        model.addAttribute("allSeasons_tickets", season_ticketService.seasonGetList(seasonId));
        return "season_ticket";
    }
}
