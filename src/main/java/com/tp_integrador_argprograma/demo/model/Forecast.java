package com.tp_integrador_argprograma.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
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

    public Forecast(Game game, Team team, String result) {
        this.game = game;
        this.team = team;
        this.result = result;
    }

    @Override
    public String toString() {
        return game.toString() + ", \n Aposto a: " + team.getName() + " que salia " + getResult();
    }
}
