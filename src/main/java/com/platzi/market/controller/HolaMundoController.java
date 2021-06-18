package com.platzi.market.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludar")

public class HolaMundoController {

    @GetMapping("/hola")
    public String saludar(){

        System.out.println("holaa");
        return "Hola mundo, aqui estoy soy Frank Jose Popo Morera un entusiasta por el desarrollo de software";
    }
}
