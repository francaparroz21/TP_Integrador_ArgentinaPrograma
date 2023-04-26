package com.tp_integrador_argprograma.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "rounds")
@Data
@NoArgsConstructor
public class Round {
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY)
    private Long teamId;

    @Column
    private String roundNum;

    @OneToMany
    @JoinColumn(name = "forecasts")
    @NonNull
    private Game[] games;
}
