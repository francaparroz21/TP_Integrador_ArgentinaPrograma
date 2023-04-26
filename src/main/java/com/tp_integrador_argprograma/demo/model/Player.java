package com.tp_integrador_argprograma.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Entity
@Table(name = "players")
@Data
@NoArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerId;

    @Column
    @NonNull
    private String name;

    @ElementCollection(targetClass = Forecast.class)
    private List<Forecast> forecasts;

    @Column
    @NonNull
    private int points;
}
