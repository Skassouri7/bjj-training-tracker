package com.skassouri.bjjtracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.*;
import java.time.format.DateTimeFormatter;

import com.skassouri.bjjtracker.domain.TrainingSession;

@RestController
public class SessionController {

    private SessionService sessionService;
    final private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d/M/yy");

    @Autowired
    public SessionController(SessionService ss){

        sessionService = ss;
    }

    @GetMapping("/sessions")
    public TrainingSession getSession(){

        return sessionService.getSessionByIndex(0);
    }
}

