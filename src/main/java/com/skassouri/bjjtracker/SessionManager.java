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

    public void removeSession(TrainingSession ts){

        this.sessions.remove(ts);
    }

    public void removeSessionByID(int sessionID){

        TrainingSession sessionToDelete = null;

        for (TrainingSession sesh: sessions){
            if (sesh.getSessionID() == sessionID){
                sessionToDelete = sesh;
            }
        }

        sessions.remove(sessionToDelete);
    }

    public ArrayList<TrainingSession> getSessions() {

        return this.sessions;
    }

    public boolean checkSessionExists(int sessionID){

        return getSession(sessionID) != null;
    }

    public TrainingSession getSession(int sessionID){

        for (TrainingSession sesh: sessions){
            if (sesh.getSessionID() == sessionID){
                return sesh;
            }
        }

        return null;
    }

}


