package com.luv2code.springcoredemo;

import org.springframework.stereotype.Component;

@Component
public class CricketPlayer implements Player{
    @Override
    public String train() { return "Let´s train!!"; }
}
