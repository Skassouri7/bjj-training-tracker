package com.skassouri.bjjtracker;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class MainMenu {
    private SessionManager sm;
    private Scanner sc;

    public MainMenu(){
        sm = new SessionManager();
        sc = new Scanner(System.in);

        actionPrompt();
    }

    public void actionPrompt() {
        System.out.println("Welcome to your personal gym Tracker !");
        System.out.println("1. Add Training Session");
        System.out.println("2. Delete Training Session");
        System.out.println("1. View Training Session");
        System.out.println("What would you like to do (Pick from 1 - 3): ");

        String inputToPrompt = sc.nextLine();

        switch (inputToPrompt){
            case "1": createTrainingSession();
                break;

            case "2": deleteTrainingSession();
                break;

            case "3": viewTrainingSession();
                break;
        }
    }

    public void createTrainingSession(){
        System.out.println("Enter Date of Training Session: ");
        LocalDate date = LocalDate.parse(sc.nextLine());

        System.out.println("Enter Start Time of Training Session: ");
        LocalTime startTime = LocalTime.parse(sc.nextLine());

        System.out.println("Enter Duration: ");
        int duration = Integer.parseInt(sc.nextLine());

        System.out.println("Enter type of Training Session: ");
        String type = sc.nextLine();

        System.out.println("Would you like to add any notes: ");
        String note = sc.nextLine();

        TrainingSession ts = new TrainingSession(date, startTime, duration, type, note);
        sm.addSession(ts);
    }

    public void deleteTrainingSession(){
        System.out.println("DELETE");
    }

    public void viewTrainingSession(){

    }

    public SessionManager getSessionManager(){
        return this.sm;
    }

}
