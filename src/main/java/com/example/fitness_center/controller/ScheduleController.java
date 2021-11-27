package com.example.fitness_center.controller;

import com.example.fitness_center.service.ScheduleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@Api(value = "Schedule Controller class", description = "This class allows to interact with Schedule object")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/schedule")
    public String scheduleList(Model model) {
        model.addAttribute("allSchedule", scheduleService.allSchedule());
        return "schedule";
    }

    @GetMapping("/schedule/gt/{scheduleId}")
    public String  gtSchedule(@PathVariable("scheduleId") Long scheduleId, Model model) {
        model.addAttribute("allSchedule", scheduleService.scheduleGetList(scheduleId));
        return "schedule";
    }
}
