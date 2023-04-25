package com.tp_integrador_argprograma.demo.service;

import com.tp_integrador_argprograma.demo.model.Forecast;
import com.tp_integrador_argprograma.demo.model.Team;
import com.tp_integrador_argprograma.demo.repository.ForecastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForecastService {
    @Autowired
    ForecastRepository repository;
    public List<Forecast> getForecasts() {
        return repository.findAll();
    }

    public Forecast saveForecast(Forecast forecast) {
        return repository.save(forecast);
    }

}
