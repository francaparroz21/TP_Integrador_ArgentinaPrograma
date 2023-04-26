package com.tp_integrador_argprograma.demo.service;

import com.tp_integrador_argprograma.demo.model.Player;
import com.tp_integrador_argprograma.demo.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository repository;

    public List<Player> getPlayers(){
        return repository.findAll();
    }

    public Player savePlayer(String name){
        Player player = new Player();
        player.setName(name);
        player.setPoints(0);
        return repository.save(player);
    }

}
