package com.tp_integrador_argprograma.demo.repository;

import com.tp_integrador_argprograma.demo.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player,Long> {
    Player findByName(String name);
}
