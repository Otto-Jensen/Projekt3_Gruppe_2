package com.example.projekt3_gruppe_2.Controller;


import com.example.projekt3_gruppe_2.Model.Car;
import com.example.projekt3_gruppe_2.Model.Status;
import com.example.projekt3_gruppe_2.Repository.carRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class carController {

    @Autowired
    carRepo carRepo;

    @GetMapping("/createCar")
    public String createCarForm (Model model){
        model.addAttribute("car", new Car());
        return "createCar";
    }

    @PostMapping("/createCar")
    public String saveCar (@RequestParam String cartNumber,
                           @RequestParam String vin,
                           @RequestParam String brand,
                           @RequestParam String model,
                           @RequestParam String color){
        Car car = new Car();
        car.setCartNumber(cartNumber);
        car.setVin(vin);
        car.setBrand(brand);
        car.setModel(model);
        car.setColor(color);
        car.setStatus(Status.AVAILABLE);
        carRepo.saveCar(car);

        return "redirect:/";
    }

}
