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

        removeSession(sessionToDelete);
    }

    public void removeSessionByIndex(int index){

        removeSession(getSessionByIndex(index));
    }

    public ArrayList<TrainingSession> getSessions() {

        return this.sessions;
    }

    public boolean checkSessionExistsByID(int sessionID){

        return getSessionByID(sessionID) != null;
    }

    public boolean checkSessionExistsByIndex(int index){

        return getSessionByIndex(index) != null;
    }

    public TrainingSession getSessionByID(int sessionID){

        for (TrainingSession sesh: sessions){
            if (sesh.getSessionID() == sessionID){
                return sesh;
            }
        }

        return null;
    }

    public TrainingSession getSessionByIndex(int index){
        return sessions.get(index);
    }

}


