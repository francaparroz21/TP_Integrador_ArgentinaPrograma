package com.tp_integrador_argprograma.demo.repository;
import com.tp_integrador_argprograma.demo.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team,Long> {}
