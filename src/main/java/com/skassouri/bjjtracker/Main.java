package com.skassouri.bjjtracker;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        LocalDate date = LocalDate.parse("2026-06-22");
        LocalTime startTime = LocalTime.parse("19:00:00");
        TrainingSession ts1 = new TrainingSession(date, startTime, 12, "hello", "hello");
        TrainingSession ts2 = new TrainingSession(date, startTime, 12, "hello", "hello");
        TrainingSession ts3 = new TrainingSession(date, startTime, 12, "hello", "hello");
        TrainingSession ts4 = new TrainingSession(date, startTime, 12, "hello", "hello");

        ArrayList<TrainingSession> sessions = new ArrayList<>();
        sessions.add(ts1);
        sessions.add(ts2);
        sessions.add(ts3);
        sessions.add(ts4);

        for (TrainingSession sesh: sessions){
            System.out.println(sesh.toString());
        }
    }
}
