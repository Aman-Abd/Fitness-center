package com.example.fitness_center.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Season_ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long season_id;
    private String season_name;
    private double price_per_day;

    @DBRef
    private List<User> users;
}
