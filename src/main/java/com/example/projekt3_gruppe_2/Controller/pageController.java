package com.example.projekt3_gruppe_2.Controller;

import com.example.projekt3_gruppe_2.Model.*;
import com.example.projekt3_gruppe_2.Repository.carRepo;
import com.example.projekt3_gruppe_2.Repository.costumerRepo;
import com.example.projekt3_gruppe_2.Repository.damageReportRepo;
import com.example.projekt3_gruppe_2.Repository.rentalAgreementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


@Controller
public class pageController {

    @Autowired
    carRepo carRepo;

    @Autowired
    costumerRepo costumerRepo;

    @Autowired
    rentalAgreementRepo rentalRepo;

    @Autowired
    damageReportRepo damageReportRepo;


    @GetMapping("/")
    public String availableCars(Model model) {
        ArrayList<Car> availCars = new ArrayList<>();

        for(Car car: carRepo.getAllCars()){
            if(car.getStatus()==Status.AVAILABLE){
                availCars.add(car);
            }
        }
        model.addAttribute("carList", availCars);
        return "availableCarsDash";
    }

    @GetMapping("/unavailableCarsDash")
    public String unavailableCars(Model model) {
        ArrayList<Car>unAvailCars= new ArrayList<>();
        for(Car car: carRepo.getAllCars()){
            if(car.getStatus()==Status.RENTED){
                unAvailCars.add(car);
            }else if(car.getStatus()==Status.UNDER_REPAIR){
                unAvailCars.add(car);
            }
        }
        model.addAttribute("carList", unAvailCars);
        return "unavailableCarsDash";
    }

    @GetMapping("/car/{id}")
    public String showCar(@PathVariable int id, Model model){

        Car car = carRepo.getCarbyId(id);
        model.addAttribute("car", car);

        if(car.getRentalAgreementId()!=null){
            rentalAgreement rental = rentalRepo.getRentalbyId(car.getRentalAgreementId());
            model.addAttribute("rental", rental);

            if(rental.getCostumerId()!=null){
                Costumer costumer = costumerRepo.getCostumerbyId(rental.getCostumerId());
                model.addAttribute("costumer", costumer);
            }
        }

        if(car.getDamageReportId()!=null){
            damageReport dmgReport = damageReportRepo.getDamageReportbyId(car.getDamageReportId());
            model.addAttribute("damageReport",dmgReport);
        }

        return "showCar";
    }

    @PostMapping("/car/status/{id}")
    public String updateStatus(@PathVariable int id, @RequestParam String status){
        Car car = carRepo.getCarbyId(id);
        car.setStatus(Status.valueOf(status));
        carRepo.editCar(car);
        return"redirect:/car/"+id;
    }


    @GetMapping("/customerInfo/{id}")
    public String customerInfo(@PathVariable int id, Model model){

        Car car = carRepo.getCarbyId(id);
        model.addAttribute("car", car);
        model.addAttribute("costumer", new Costumer());
        model.addAttribute("rental", new rentalAgreement());

        return "costumerInfo";
    }





}

