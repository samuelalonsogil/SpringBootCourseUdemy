package com.springboot.demo.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    /*expose "/" that returns a "Hello World!"*/
    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }
}
