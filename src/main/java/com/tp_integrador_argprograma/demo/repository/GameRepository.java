package com.tp_integrador_argprograma.demo.repository;

import com.tp_integrador_argprograma.demo.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
}
