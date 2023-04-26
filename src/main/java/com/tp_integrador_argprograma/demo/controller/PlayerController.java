package com.tp_integrador_argprograma.demo.controller;

import com.tp_integrador_argprograma.demo.model.Player;
import com.tp_integrador_argprograma.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/players")
public class PlayerController {
    @Autowired
    PlayerService service;

    @GetMapping
    public String getPlayers(Model model) {
        model.addAttribute("players",service.getPlayers());
        return "players";
    }

    @PostMapping
    public ResponseEntity<Player> savePlayer(@RequestBody Player player){
        return new ResponseEntity<>(service.savePlayer(player), HttpStatus.CREATED);
    }
}
