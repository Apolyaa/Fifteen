package com.example.fifteen.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Game implements Comparable<Game>{
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

    public String getTime() {
        double seconds = Math.floor((time / 1000) % 60);
        double minutes = Math.floor((time / (1000 * 60)) % 60);
        double hours = Math.floor((time / (1000 * 60 * 60)) % 24);


        String hours_text = (hours < 10) ? "0" + String.valueOf((int) hours) : String.valueOf((int) hours);
        String minutes_text = (minutes < 10) ? "0" + String.valueOf((int) minutes) : String.valueOf((int) minutes);
        String seconds_text = (seconds < 10) ? "0" + String.valueOf((int) seconds) : String.valueOf((int) seconds);

        return hours_text + ":" + minutes_text + ":" + seconds_text;
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

    @Override
    public int compareTo(Game o) {
        return this.clicks - o.getClicks();
    }
}
