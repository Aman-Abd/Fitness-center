package com.example.fitness_center.controller;

import com.example.fitness_center.service.TrainerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@Api(value = "Trainer Controller class", description = "This class allows to interact with Trainer object")
public class TrainerController {
    @Autowired
    private TrainerService trainerService;

    @GetMapping("/trainer")
    public String trainerList(Model model) {
        model.addAttribute("allTrainers", trainerService.allTrainers());
        return "trainer";
    }

    @GetMapping("/trainer/gt/{trainerId}")
    public String  gtTrainer(@PathVariable("trainerId") Long trainerId, Model model) {
        model.addAttribute("allTrainers", trainerService.trainerGetList(trainerId));
        return "trainer";
    }
}
