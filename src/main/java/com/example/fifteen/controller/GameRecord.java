package com.example.fifteen.controller;

import java.util.Date;

public class GameRecord {
    private Date date;
    private String userName;
    private Integer time;
    private Integer clicks;

    @Override
    public String toString() {
        return "GameRecord{" +
                "date=" + date +
                ", user=" + userName +
                ", time=" + time +
                ", clicks=" + clicks +
                '}';
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
}
