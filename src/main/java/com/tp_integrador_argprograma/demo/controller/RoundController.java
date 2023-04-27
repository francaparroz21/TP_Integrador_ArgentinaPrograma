package com.tp_integrador_argprograma.demo.controller;

import com.tp_integrador_argprograma.demo.model.Round;
import com.tp_integrador_argprograma.demo.service.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rounds")
public class RoundController {

    @Autowired
    RoundService service;

    @GetMapping
    public ResponseEntity<List<Round>> getRounds(){
        return ResponseEntity.ok(service.getRounds());
    }

    @PostMapping
    public ResponseEntity<Round> saveRound(@RequestBody Round round){
        return new ResponseEntity<>(service.saveRound(round), HttpStatus.CREATED);
    }
}
