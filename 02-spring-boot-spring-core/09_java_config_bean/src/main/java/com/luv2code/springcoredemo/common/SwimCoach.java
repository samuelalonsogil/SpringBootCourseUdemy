package com.luv2code.springcoredemo.common;

public class SwimCoach implements Coach{

    public SwimCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim training!!";
    }

    @Override
    public String getDailyCoaching() {
        return null;
    }
}
