package com.example.fifteen.service;

import com.example.fifteen.model.Game;
import com.example.fifteen.repo.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService implements IGameService {
    @Autowired
    private GameRepository repository;

    @Override
    public List<Game> findAll() {
        var games =  (List<Game>) repository.findAll();
        return games;
    }

}
