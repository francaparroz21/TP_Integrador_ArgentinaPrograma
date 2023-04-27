package com.tp_integrador_argprograma.demo.service;

import com.tp_integrador_argprograma.demo.model.Team;
import com.tp_integrador_argprograma.demo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public boolean deleteTeam(Long id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public Team updateTeam(Long id,Team team) {
        Team teamFinded = repository.findById(id).get();

        if (!teamFinded.getName().equals(team.getName())) teamFinded.setName(team.getName());
        if (!teamFinded.getDescription().equals(team.getDescription())) teamFinded.setDescription(team.getDescription());

        return repository.save(teamFinded);
    }
}
