package com.tp_integrador_argprograma.demo.model;

import com.tp_integrador_argprograma.demo.exceptions.EquipoNoEncontrado;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "matchs")
@Entity
public class Partido {
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY)
    private Long id;
    @Column
    private Team team1;
    @Column
    private Team team2;
    @Column
    private int golesEquipo1;
    @Column
    private int golesEquipo2;

    public ResultadoEnum resultado(Team e) throws EquipoNoEncontrado {
        if (e == team1) {
            if (golesEquipo1 > golesEquipo2) return ResultadoEnum.Ganador;
            else if (golesEquipo1 == golesEquipo2) return ResultadoEnum.Empate;
            return ResultadoEnum.Perdedor;
        } else if (e == team2) {
            if (golesEquipo1 < golesEquipo2) return ResultadoEnum.Ganador;
            else if (golesEquipo1 == golesEquipo2) return ResultadoEnum.Empate;
            return ResultadoEnum.Perdedor;
        }
        throw new EquipoNoEncontrado();
    }
}
