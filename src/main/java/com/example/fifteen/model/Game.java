package com.example.fifteen.model;


import com.example.fifteen.controller.TaskController;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private Date date;
    private String userName;
    private Integer time;
    private Integer clicks;

    public Game(Date date, String userName, Integer time, Integer clicks) {
        this.date = date;
        this.userName = userName;
        this.time = time;
        this.clicks = clicks;

        Logger logger = LoggerFactory.getLogger(TaskController.class);
        logger.info("with param");
        logger.info(this.toString());
    }

    public Game() {

    }

    @Override
    public String toString() {

        return "Game{" +
                "id=" + id +
                ", date=" + date +
                ", user=" + userName +
                ", time=" + time +
                ", clicks=" + clicks +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getUserName() {
        return userName;
    }

    public Integer getTime() {
        return time;
    }

    public Integer getClicks() {
        return clicks;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public void setClicks(Integer clicks) {
        this.clicks = clicks;
    }
}
