package com.example.fifteen.controller;

import com.example.fifteen.model.Game;
import com.example.fifteen.repo.GameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {
    @Autowired
    GameRepository repo;
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
    public void saveGameData(@RequestBody GameRecord request) {
        Logger logger = LoggerFactory.getLogger(TaskController.class);
        logger.info("saveGameData");
        logger.info(request.toString());

        Game newRecord = new Game(request.getDate(),
                            request.getUserName(),
                            request.getTime(),
                            request.getClicks());

        logger.info(newRecord.toString());
        repo.save(newRecord);
    }
    @GetMapping("/all")
    public @ResponseBody Iterable<Game> getAll(){
        return repo.findAll();
    }
}
