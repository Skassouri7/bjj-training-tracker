package com.skassouri.bjjtracker;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class MainMenu {
    private SessionManager sm;
    private Scanner sc;
    private boolean active = true;

    public MainMenu(){
        sm = new SessionManager();
        sc = new Scanner(System.in);
    }

    public void startMenu (){

        while (active){
            System.out.println("Welcome to your personal gym Tracker !");
            System.out.println("1. Add Training Session");
            System.out.println("2. Delete Training Session");
            System.out.println("3. View Training Session");
            System.out.println("4. Exit");

            actionPrompt();
        }
    }

    public void actionPrompt() {

        System.out.println("What would you like to do (Pick from 1 - 4): ");

        String choice = sc.nextLine();

        switch (choice){
            case "1": createTrainingSession();
                break;

            case "2": deleteTrainingSession();
                break;

            case "3": viewTrainingSession();
                break;

            case "4": exitMainMenu();
                break;

            default:
                System.out.println("You have entered an invalid input !");
                break;
        }
    }

    public void createTrainingSession(){
        System.out.println("Enter Date of Training Session: ");
        LocalDate date = LocalDate.parse(sc.nextLine());

        System.out.println("Enter Start Time of Training Session: ");
        LocalTime startTime = LocalTime.parse(sc.nextLine());

        int duration = 0;

        while (duration <= 0){

            try {

                System.out.println("Enter Duration (Minutes): ");
                duration = Integer.parseInt(sc.nextLine());

            } catch (NumberFormatException nfe){

                System.out.println("You have entered an invalid input. Please enter a valid number representing duration (in minutes)");

            }

        }

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
        if (sm.getSessions().isEmpty()){
            System.out.println("No training sessions found.");

        }
        else {
            for (TrainingSession sesh: sm.getSessions()){
                System.out.println(sesh.toString());
            }
        }
    }

    public void exitMainMenu(){
        active = false;
        sc.close();
    }

}
