package com.example.projekt3_gruppe_2.Controller;

import com.example.projekt3_gruppe_2.Model.Car;
import com.example.projekt3_gruppe_2.Repository.carRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.sql.DataSource;
import java.util.ArrayList;

@Controller
public class pageController {

    @Autowired
    carRepo carRepo;


    @GetMapping("/")
    public String availableCars(Model model) {

        model.addAttribute("carList", carRepo.getAllCars());
        return "availableCarsDash";
    }

    @GetMapping("/unavailableCars")
    public String unavailableCars() {

        return "unavailableCarsDash";
    }


}

