package com.luv2code.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class TrackCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Do Track practice !!";
    }

    @Override
    public String getDailyCoaching() {
        return null;
    }
}
