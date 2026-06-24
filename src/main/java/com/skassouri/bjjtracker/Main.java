package com.skassouri.bjjtracker;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        MainMenu mm = new MainMenu();


        for (TrainingSession sesh: mm.getSessionManager().getSessions()){
            System.out.println(sesh.toString());
        }
    }
}
