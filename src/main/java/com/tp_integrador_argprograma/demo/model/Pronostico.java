package com.tp_integrador_argprograma.demo.model;

import com.tp_integrador_argprograma.demo.exceptions.EquipoNoEncontrado;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "forecasts")
public class Pronostico {
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY)
    private Long id;
    @Column
    private Partido partido;
    @Column
    private String nroRonda;
    @Column
    private Team team;
    @Column
    private ResultadoEnum resultado;

    public int puntos() throws EquipoNoEncontrado {
        if (getPartido().resultado(getTeam()) == getResultado()) return 1;
        return 0;
    }
}
