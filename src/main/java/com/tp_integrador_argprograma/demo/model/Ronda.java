package com.tp_integrador_argprograma.demo.model;

import com.tp_integrador_argprograma.demo.model.Partido;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "rounds")
@Data
public class Ronda {
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nro;
    @Column
    private Partido[] partidos;

}
