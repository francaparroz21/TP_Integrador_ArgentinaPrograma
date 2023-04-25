package com.tp_integrador_argprograma.demo.service;

import com.tp_integrador_argprograma.demo.model.Round;
import com.tp_integrador_argprograma.demo.repository.RoundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoundService {

    @Autowired
    RoundRepository repository;

    public List<Round> getRounds() {
        return repository.findAll();
    }

    public Round saveRound(Round round) {
        return repository.save(round);
    }
}
