package com.tp_integrador_argprograma.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Table(name = "teams")
@Entity
@Data
@NoArgsConstructor
public class Team {
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY)
    private Long teamId;
    @NonNull
    @Column
    private String name;
    @NonNull
    @Column
    private String description;

}
