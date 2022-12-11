package com.example.fifteen.controller;

import com.example.fifteen.model.Game;
import com.example.fifteen.repo.GameRepository;
import com.example.fifteen.service.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Controller
public class TaskController {
    @Autowired
    GameRepository repo;
    @Autowired
    private IGameService gameService;

    @GetMapping("/")
    public String start() {
        return "start";
    }

    @GetMapping("/game")
    public String game() {
        return "game";
    }

    @GetMapping("/reward")
    public String reward() {
        return "reward";
    }

    @PostMapping("/saveGameData")
    @ResponseStatus(HttpStatus.OK)
    public void saveGameData(@RequestBody Game request) {
        repo.save(request);
    }

    @GetMapping("/records")
    public String records(Model model) {

        List<Game> games = gameService.findAll();
        Collections.sort(games);
        List<Game> games_top10 = new ArrayList<Game>();
        Integer size = games.size();
        if (size>10)
                size =10;
        for (Integer i=0;i<size;i++)
            games_top10.add(games.get(i));
        model.addAttribute("records", games_top10);
        return "records";
    }

}