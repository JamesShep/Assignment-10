package com.coderscampus.Assignment10.dto;

public class WeekResponse {
    private Week week;

    public Week getWeek() {
        return week;
    }

    public void setWeek(Week week) {
        this.week = week;
    }

    @Override
    public String toString() {
        return "WeekResponse{" +
                "week=" + week +
                '}';
    }
}