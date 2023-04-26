package com.tp_integrador_argprograma.demo.service;

import com.tp_integrador_argprograma.demo.model.Forecast;
import com.tp_integrador_argprograma.demo.model.Player;
import com.tp_integrador_argprograma.demo.repository.ForecastRepository;
import com.tp_integrador_argprograma.demo.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForecastService {
    @Autowired
    ForecastRepository forecastRepository;
    @Autowired
    PlayerRepository playersRepository;
    public List<Forecast> getForecasts() {
        return forecastRepository.findAll();
    }

    public Forecast saveForecast(Forecast forecast) {
        return forecastRepository.save(forecast);
    }


    public List<Forecast> savePlayerForecast(Long id, Forecast forecast) {
        Player playerFinded = playersRepository.findById(id).get();
        playerFinded.getForecasts().add(forecast);
        forecastRepository.save(forecast);
        playersRepository.save(playerFinded);

        return playerFinded.getForecasts();
    }
}
