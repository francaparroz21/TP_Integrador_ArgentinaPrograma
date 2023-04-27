package com.tp_integrador_argprograma.demo.service;

import com.tp_integrador_argprograma.demo.model.Player;
import com.tp_integrador_argprograma.demo.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository repository;

    public List<Player> getPlayers(){
        ArrayList<Player> players = (ArrayList<Player>) repository.findAll();
        players.sort(new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return Integer.compare(o1.getPoints(), o2.getPoints());
            }
        });
        return players;
    }

    public Player savePlayer(String name){
        Player player = new Player();
        player.setName(name.toLowerCase());
        player.setPoints(0);
        return repository.save(player);
    }

    public Player getPlayerByName(String name) {
        Player player = repository.findByName(name.toLowerCase());
        if (player != null) return player;
        return savePlayer(name.toLowerCase());
    }
}
