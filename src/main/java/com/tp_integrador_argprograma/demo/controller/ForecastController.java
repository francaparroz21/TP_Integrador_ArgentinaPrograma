package com.tp_integrador_argprograma.demo.controller;

import com.tp_integrador_argprograma.demo.exceptions.EquipoNoEncontrado;
import com.tp_integrador_argprograma.demo.model.Forecast;
import com.tp_integrador_argprograma.demo.model.Team;
import com.tp_integrador_argprograma.demo.service.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/forecasts")
public class ForecastController {

    @Autowired
    ForecastService service;

    @GetMapping
    public ResponseEntity<List<Forecast>> getForecasts() {
        return ResponseEntity.ok(service.getForecasts());
    }

    @PostMapping
    public ResponseEntity<Forecast> saveForecast(@RequestBody Forecast forecast) {
        return new ResponseEntity<>(service.saveForecast(forecast), HttpStatus.CREATED);
    }

    @PostMapping(value = "/{name}")
    public ResponseEntity<List<Forecast>> savePlayerForecast(@PathVariable("name") String name,
                                                             @RequestParam String matchId,
                                                             @RequestParam String teamId,
                                                             @RequestParam String result
    ) throws EquipoNoEncontrado {
        return new ResponseEntity<>(service.savePlayerForecast(name,matchId,teamId,result), HttpStatus.CREATED);
    }

}
