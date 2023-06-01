package com.springboot.demo.demo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    /*expose "/" that returns a "Hello World!"*/
    @GetMapping("/")
    public String sayHello(){
        return coachName + " " + teamName;
    }

    /*expose a new endpoint for 'workout'*/
    @GetMapping("/workout")
    public String getDailyWorkOut(){
        return "Run a hard 5k!";
    }


    /*expose a new endpoint for 'fortune'*/
    @GetMapping("/fortune")
    public String getFortune(){
        return "Fortune!";
    }

}
