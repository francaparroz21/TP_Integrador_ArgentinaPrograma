package com.tp_integrador_argprograma.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "teams")
@Entity
@Data
public class Team {
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column
    private String descripcion;
}
