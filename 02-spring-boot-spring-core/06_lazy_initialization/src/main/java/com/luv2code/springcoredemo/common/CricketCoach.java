package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

/*makes the class available for dependency injection (makes it a Spring Bean)*/
@Component
public class CricketCoach implements Coach{


    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes :D!!!";
    }

    @Override
    public String getDailyCoaching() { return "Good job !!";
    }
}
