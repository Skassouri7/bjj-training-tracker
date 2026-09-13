package com.skassouri.bjjtracker;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class MainMenu {

    private SessionManager sm;
    private Scanner sc;
    private boolean active = true;
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d/M/yy");

    public MainMenu(){

        sm = new SessionManager();
        sc = new Scanner(System.in);
    }

    public void startMenu (){

        System.out.println("Welcome to your personal gym Tracker !");

        while (active){
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

        LocalDate date = null;

        System.out.println("Enter Date of Training Session (dd/mm/yy): ");

        while (date == null){
            try{
                date = LocalDate.parse(sc.nextLine(), dateFormatter);

            } catch(DateTimeParseException dte){
                System.out.println("You have entered an invalid date, Please enter the date in the correct format (dd/mm/yy)");
            }
        }

        LocalTime startTime= null;
        System.out.println("Enter Start Time of Training Session (00:00): ");

        while (startTime == null){
            try {
                startTime = LocalTime.parse(sc.nextLine());

            } catch(DateTimeParseException dte) {
                System.out.println("You have entered an incorrect time. Please enter start time in correct format (00:00)");
            }
        }

        int duration = 0;

        while (duration <= 0){
            try {
                System.out.println("Enter Duration (Minutes): ");
                duration = Integer.parseInt(sc.nextLine());

            } catch (NumberFormatException nfe){
                System.out.println("You have entered an invalid input. Please enter a valid number representing duration (in minutes)");
            }
        }

        //Validate training type / TrainingType Enum ?
        System.out.println("Enter type of Training Session: ");
        String type = sc.nextLine();

        System.out.println("Would you like to add any notes: ");
        String note = sc.nextLine();

        TrainingSession ts = new TrainingSession(date, startTime, duration, type, note);
        sm.addSession(ts);
    }

    public void deleteTrainingSession(){

        while (true){
            if (sm.getSessions().isEmpty()) {
                System.out.println("No training sessions found.");
                return;
            }
            else {
                for (TrainingSession sesh : sm.getSessions()) {
                    System.out.println(sesh.getSummary());
                }

                System.out.println("Which training session would you like to delete? (Pick session number) - enter 0 if you want to cancel");
                int userChoice = 0;

                try {
                    userChoice = Integer.parseInt(sc.nextLine());

                    if (sm.checkSessionExists(userChoice) && userChoice != 0) {
                        boolean confirmationComplete = false;

                        while (!confirmationComplete){
                            System.out.println("Are you sure you want to delete this session? y/n");
                            String deleteConfirmationInput = sc.nextLine();

                            switch (deleteConfirmationInput) {
                                case "y": {
                                    String deletedTempSummary = sm.getSession(userChoice).getSummary();
                                    sm.removeSessionByID(userChoice);
                                    System.out.println("Session (" + deletedTempSummary + ") has been deleted !");
                                    confirmationComplete = true;
                                    break;
                                }

                                case "n":
                                    confirmationComplete = true;
                                    break;

                                default:
                                    System.out.println("Please enter a valid input (y/n)");
                            }
                        }
                    } else if(userChoice == 0){
                        return;
                    } else if(!sm.checkSessionExists(userChoice)){
                        System.out.println("Session doesn't exist");
                    }
                } catch (NumberFormatException nfe){

                        System.out.println("Please enter a valid number choice");
                }
            }
        }
    }

    public void viewTrainingSession(){

        if (sm.getSessions().isEmpty()){
            System.out.println("No training sessions found.");
        }
        else {
            for (TrainingSession sesh: sm.getSessions()){
                System.out.println(sesh.getSummary());
            }
        }

        System.out.println("Press Enter to continue.....");
        sc.nextLine();
    }

    public void exitMainMenu(){

        active = false;
        sc.close();
    }

}
