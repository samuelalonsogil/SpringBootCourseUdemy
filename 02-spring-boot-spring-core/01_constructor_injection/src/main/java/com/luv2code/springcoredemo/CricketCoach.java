package com.luv2code.springcoredemo;

import org.springframework.stereotype.Component;

/*makes the class available for dependency injection (makes it a Spring Bean)*/
@Component
public class CricketCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!!!";
    }

    @Override
    public String getDailyCoaching() { return "Good job !!";
    }
}
