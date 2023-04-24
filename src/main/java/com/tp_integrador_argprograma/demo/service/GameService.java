package com.tp_integrador_argprograma.demo.service;

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
}
