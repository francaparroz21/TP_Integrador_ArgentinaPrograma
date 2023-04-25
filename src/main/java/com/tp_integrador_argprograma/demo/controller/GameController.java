package com.tp_integrador_argprograma.demo.controller;

import com.tp_integrador_argprograma.demo.model.Game;
import com.tp_integrador_argprograma.demo.model.Team;
import com.tp_integrador_argprograma.demo.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {
    @Autowired
    GameService service;

    @GetMapping
    public ResponseEntity<List<Game>> getGames(){
        return ResponseEntity.ok(service.getGames());
    }

    @PostMapping
    public ResponseEntity<Game> saveGame(@RequestBody Game game){
        return new ResponseEntity<>(service.saveGame(game), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteGame(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.deleteGame(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Game> updateGame(@PathVariable("id") Long id,@RequestBody Game game){
        return ResponseEntity.ok(service.updateGame(id,game));
    }
}
