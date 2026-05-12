package com.example.projekt3_gruppe_2.Controller;

import com.example.projekt3_gruppe_2.Model.Car;
import com.example.projekt3_gruppe_2.Model.Status;
import com.example.projekt3_gruppe_2.Repository.carRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class pageController {

    @Autowired
    carRepo carRepository;

    @GetMapping("/availableCars")
    public String availableCars(Model model) {
        List<Car> allCars = carRepository.getAllCars();
        List<Car> availableCars = allCars.stream()
                .filter(car -> car.getStatus() == Status.AVAILABLE)
                .collect(Collectors.toList());
        model.addAttribute("cars", availableCars);
        return "availableCarsDash";
    }

    @GetMapping("/unavailableCars")
    public String unavailableCars(Model model) {
        List<Car> allCars = carRepository.getAllCars();
        List<Car> unavailableCars = allCars.stream()
                .filter(car -> car.getStatus() != Status.AVAILABLE)
                .collect(Collectors.toList());
        model.addAttribute("cars", unavailableCars);
        return "unavailableCarsDash";
    }
}
