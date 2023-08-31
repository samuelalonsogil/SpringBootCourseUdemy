package com.luv2code.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

/*makes the class available for dependency injection (makes it a Spring Bean)*/
@Component
public class CricketCoach implements Coach{


    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    /*define init method*/
    @PostConstruct
    public void doStartupStuff(){
        System.out.println("In my doStartupStuff(): " + getClass().getSimpleName());
    }
    /*define destroy method*/
    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("In my doMyCleanupStuff(): " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes :D!!!";
    }

    @Override
    public String getDailyCoaching() { return "Good job !!";
    }
}
