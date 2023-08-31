package com.luv2code.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class TrackCoach implements Coach{
    public TrackCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Do Track practice !!";
    }

    @Override
    public String getDailyCoaching() {
        return null;
    }
}
