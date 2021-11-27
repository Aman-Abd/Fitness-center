package com.example.fitness_center.entity;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Season_ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long season_id;
    private String season_name;
    private double price_per_day;

    @OneToMany(mappedBy = "season_ticket", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<User> users;
}
