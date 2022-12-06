package com.example.fifteen.controller;

import com.example.fifteen.model.Game;
import com.example.fifteen.repo.GameRepository;
import com.example.fifteen.service.IGameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        Logger logger = LoggerFactory.getLogger(TaskController.class);
        logger.info("saveGameData");
        logger.info(request.toString());

        repo.save(request);
    }

    @GetMapping("/records")
    public String records(Model model) {

        List<Game> games = gameService.findAll();
        model.addAttribute("records", games);
        System.out.println("records:");
        games.forEach(game -> System.out.println(game.toString()));

        return "records";
    }

    @GetMapping(produces = {"application/json"}, value = "/findAll" )
    @ResponseBody
    public List<Game> records() {
        List<Game> games = gameService.findAll();
        System.out.println("findAll:");
        games.forEach(game -> System.out.println(game.toString()));
        return games;
    }

    @GetMapping("/first")
    @ResponseBody
    public ResponseEntity<Game> first() {
        List<Game> games = gameService.findAll();
        Game firstGame = games.get(0);
        System.out.println("first:");
        System.out.println(firstGame.toString());

        return ResponseEntity.ok(firstGame);
    }

}