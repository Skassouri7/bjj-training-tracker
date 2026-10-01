package com.skassouri.bjjtracker;

import com.skassouri.bjjtracker.domain.TrainingSession;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SessionService {

    private ArrayList<TrainingSession> sessions;

    public SessionService(){

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

    public List<TrainingSession> getSessions() {

        return List.copyOf(sessions);
    }

    public boolean checkSessionExistsByID(int sessionID){

        return getSessionByID(sessionID) != null;
    }

    public boolean checkSessionExistsByIndex(int index){

        return index >= 0 && index < sessions.size();
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

        if (checkSessionExistsByIndex(index)){
            return sessions.get(index);
        }

        return null;
    }
}
