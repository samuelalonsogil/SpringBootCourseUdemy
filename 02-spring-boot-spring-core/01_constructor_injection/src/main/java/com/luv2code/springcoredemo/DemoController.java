package com.luv2code.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    /*define a private field for the dependency*/
    private Coach myCoach;
    private Player myPlayer;

    /*define a constructor for dependency injection*/
    @Autowired
    public DemoController (Coach coach, Player player){
        myCoach = coach;
        myPlayer = player;

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
