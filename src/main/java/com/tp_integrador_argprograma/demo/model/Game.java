package com.tp_integrador_argprograma.demo.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Table(name = "games")
@Entity
@Data
@NoArgsConstructor
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gameId;
    @ManyToOne
    @JoinColumn(name = "team1")
    @NonNull
    private Team team1;
    @ManyToOne
    @JoinColumn(name = "team2")
    @NonNull
    private Team team2;
    @NonNull
    @Column
    private int goalsTeam1;
    @NonNull
    @Column
    private int goalsTeam2;

    @Override
    public String toString() {
        return "Partido: " + getTeam1().getName() + "(" + getGoalsTeam1() + ")" + getTeam2().getName() + "(" + getGoalsTeam2() + ")";
    }
}
