package com.tp_integrador_argprograma.demo.repository;

import com.tp_integrador_argprograma.demo.model.Forecast;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForecastRepository extends JpaRepository<Forecast,Long> {
}
