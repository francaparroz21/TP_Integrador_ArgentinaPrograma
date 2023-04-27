package com.tp_integrador_argprograma.demo.service;

import com.tp_integrador_argprograma.demo.exceptions.EquipoNoEncontrado;
import com.tp_integrador_argprograma.demo.model.Forecast;
import com.tp_integrador_argprograma.demo.model.Game;
import com.tp_integrador_argprograma.demo.model.Player;
import com.tp_integrador_argprograma.demo.model.Team;
import com.tp_integrador_argprograma.demo.repository.ForecastRepository;
import com.tp_integrador_argprograma.demo.repository.GameRepository;
import com.tp_integrador_argprograma.demo.repository.PlayerRepository;
import com.tp_integrador_argprograma.demo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForecastService {
    @Autowired
    ForecastRepository forecastRepository;
    @Autowired
    GameRepository gameRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    PlayerRepository playersRepository;

    public List<Forecast> getForecasts() {
        return forecastRepository.findAll();
    }

    public Forecast saveForecast(Forecast forecast) {
        return forecastRepository.save(forecast);
    }


    public List<Forecast> savePlayerForecast(String name, String matchId, String teamId, String result) throws EquipoNoEncontrado {
        Player playerFinded = playersRepository.findByName(name);
        Game gameFinded = gameRepository.findById(Long.parseLong(matchId)).get();
        Team teamFinded = teamRepository.findById(Long.parseLong(teamId)).get();

        Forecast forecast = new Forecast(gameFinded, teamFinded,result);
        playerFinded.getForecasts().add(forecast);
        forecastRepository.save(forecast);
        if (gameFinded.result(teamFinded).equals(result)) playerFinded.setPoints(playerFinded.getPoints()+1);
        playersRepository.save(playerFinded);
        return playerFinded.getForecasts();
    }
}
