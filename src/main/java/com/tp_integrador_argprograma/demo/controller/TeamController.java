package com.tp_integrador_argprograma.demo.controller;

import com.tp_integrador_argprograma.demo.model.Team;
import com.tp_integrador_argprograma.demo.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/teams")
public class TeamController {

    @Autowired
    TeamService service;

    @GetMapping
    public ResponseEntity<List<Team>> getTeams(){
        return ResponseEntity.ok(service.getTeams());
    }

    @PostMapping
    public ResponseEntity<Team> saveTeam(@RequestBody Team team){
        return new ResponseEntity<>(service.saveTeam(team), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteTeam(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.deleteTeam(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<Team> updateTeam(@PathVariable("id") Long id,@RequestBody Team team){
        return ResponseEntity.ok(service.updateTeam(id,team));
    }

}
