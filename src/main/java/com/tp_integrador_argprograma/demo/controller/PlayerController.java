package com.tp_integrador_argprograma.demo.controller;

import com.tp_integrador_argprograma.demo.model.Player;
import com.tp_integrador_argprograma.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/players")
public class PlayerController {
    @Autowired
    PlayerService service;

    @GetMapping
    public ResponseEntity<List<Player>> getPlayers() {
        return ResponseEntity.ok(service.getPlayers());
    }

    @PostMapping
    public ResponseEntity<Player> savePlayer(@RequestBody Player player){
        return new ResponseEntity<>(service.savePlayer(player), HttpStatus.CREATED);
    }
}
