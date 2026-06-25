package com.skassouri.bjjtracker;

import java.util.ArrayList;

public class SessionManager {

    private ArrayList<TrainingSession> sessions;

    public SessionManager(){

        this.sessions = new ArrayList<>();
    }

    public void addSession(TrainingSession ts){

        this.sessions.add(ts);
    }

    public ArrayList<TrainingSession> getSessions() {

        return this.sessions;
    }
}
