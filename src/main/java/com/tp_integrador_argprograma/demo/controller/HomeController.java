package com.tp_integrador_argprograma.demo.controller;

import com.tp_integrador_argprograma.demo.service.GameService;
import com.tp_integrador_argprograma.demo.service.PlayerService;
import com.tp_integrador_argprograma.demo.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/")
public class HomeController {
    @Autowired
    PlayerService playerService;
    @Autowired
    GameService gameService;
    @Autowired
    TeamService teamService;

    @GetMapping
    public String getHome(){
        return "index";
    }

    @GetMapping(value = "/play")
    public String getPlay(Model model, @RequestParam String name){
        model.addAttribute("user", playerService.getPlayerByName(name));
        model.addAttribute("players", playerService.getPlayers());
        model.addAttribute("games",gameService.getGames());
        model.addAttribute("teams",teamService.getTeams());
        return "play";
    }


}
