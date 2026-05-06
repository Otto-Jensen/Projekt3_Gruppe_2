package com.example.projekt3_gruppe_2.Controller;

import org.springframework.web.bind.annotation.GetMapping;

public class pageController {

    @GetMapping("/availableCars")
    public String availableCars() {

        return "availableCarsDash";
    }
}

