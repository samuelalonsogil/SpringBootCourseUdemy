package com.pokedex_project.controller;

import com.pokedex_project.model.Pokemon;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class MainController {

    @GetMapping("/")
    public String getHomePage(Model model){
        //model.addAttribute("pokemon", new Pokemon() );
        return "home-page";
    }

    @PostMapping("/get-pokemon")
    public String getPokemon(
            @Valid
            @ModelAttribute("pokemon")
            Pokemon pokemon, BindingResult bindingResult){

        System.out.println("get pokémon!" + pokemon);

        String url = "https://pokeapi.co/api/v2/" + pokemon;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);

        System.out.println("result pokémon");

        return "hey";

        /*if (bindingResult.hasErrors() ) return "home-page";
        else return "pokemon-page";*/

    }
    
}
