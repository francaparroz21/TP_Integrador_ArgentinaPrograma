package com.tp_integrador_argprograma.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "forecasts")
@Data
@NoArgsConstructor
public class Forecast {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long forecastId;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "game")
    private Game game;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "team")
    private Team team;
    @NonNull
    @Column
    private String result;
}
