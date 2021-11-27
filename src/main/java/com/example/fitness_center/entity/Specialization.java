package com.example.fitness_center.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(of={"id"})
@NoArgsConstructor
@AllArgsConstructor
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long specialization_id;
    private String specialization_name;

    @OneToOne(mappedBy = "specialization", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Trainer trainer;
}
