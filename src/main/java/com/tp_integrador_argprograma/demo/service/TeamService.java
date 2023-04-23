package com.tp_integrador_argprograma.demo.service;

import com.tp_integrador_argprograma.demo.model.Team;
import com.tp_integrador_argprograma.demo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {

    @Autowired
    TeamRepository repository;

    public List<Team> getTeams() {
        return repository.findAll();
    }

    public Team saveTeam(Team team) {
        return repository.save(team);
    }
}
