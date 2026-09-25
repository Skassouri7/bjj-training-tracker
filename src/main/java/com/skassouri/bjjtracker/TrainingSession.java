package com.skassouri.bjjtracker;

import java.time.LocalDate;
import java.time.LocalTime;

public class TrainingSession {

    private static int sessionsCount = 0;
    private int sessionID = 0;
    private LocalDate date;
    private LocalTime startTime;
    private int durationMins;
    private String type;
    private String note;

    public TrainingSession(LocalDate date, LocalTime startTime, int duration, String type, String note) {

        sessionsCount++;
        sessionID = sessionsCount;
        this.date = date;
        this.startTime = startTime;
        this.durationMins = duration;
        this.type = type;
        this.note = note;
    }


    public int getSessionID(){

        return sessionID;
    }

    public LocalDate getDate(){

        return this.date;
    }

    public LocalTime getStartTime(){

        return this.startTime;
    }
    public int getDuration(){

        return this.durationMins;
    }

    public String getType(){

        return this.type;
    }

    public String getNote(){

       return this.note;
    }

    public String getSummary(){
        return date + " - " + type;
    }

    @Override
    public String toString() {

        return "TrainingSession{" +
                "SessionID=" + sessionID +
                "date=" + date +
                ", startTime=" + startTime +
                ", duration=" + durationMins +
                ", type='" + type + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
