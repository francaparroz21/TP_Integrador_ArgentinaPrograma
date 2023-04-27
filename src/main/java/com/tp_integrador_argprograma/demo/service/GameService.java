package com.tp_integrador_argprograma.demo.service;

import com.tp_integrador_argprograma.demo.controller.GameController;
import com.tp_integrador_argprograma.demo.model.Game;
import com.tp_integrador_argprograma.demo.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class GameService {
    @Autowired
    GameRepository repository;

    public List<Game> getGames() {
        return repository.findAll();
    }

    public Game saveGame(Game game) {
        return repository.save(game);
    }

    public boolean deleteGame(Long id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public Game updateGame(Long id, Game game) {
        Game gameFinded = repository.findById(id).get();
        if (!gameFinded.getTeam1().equals(game.getTeam1())) gameFinded.setTeam1(game.getTeam1());
        if (!gameFinded.getTeam2().equals(game.getTeam2())) gameFinded.setTeam2(game.getTeam2());
        if (gameFinded.getGoalsTeam1() != game.getGoalsTeam1()) gameFinded.setGoalsTeam1(game.getGoalsTeam1());
        if (gameFinded.getGoalsTeam2() != game.getGoalsTeam2()) gameFinded.setGoalsTeam2(game.getGoalsTeam2());
        return repository.save(gameFinded);
    }
}
