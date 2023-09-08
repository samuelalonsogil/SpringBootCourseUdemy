package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import com.luv2code.springcoredemo.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    /*define a private field for the dependency*/
    private Coach myCoach;
    private Player myPlayer;

    /*define a constructor for dependency injection*/
    @Autowired
    public DemoController (
            @Qualifier("aqua") Coach theCoach
    ){
        System.out.println("In constructor: " + getClass().getSimpleName());
        myCoach = theCoach;

    }

    @GetMapping("/")
    public String hello(){
        return "hello!";
    }



    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }


    @GetMapping("/dailycoaching")
    public String getDailyCoaching(){
        return myCoach.getDailyCoaching();
    }

    @GetMapping("/train")
    public String train(){
        return myPlayer.train();
    }
}
