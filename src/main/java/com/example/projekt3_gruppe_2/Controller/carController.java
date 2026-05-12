package com.example.projekt3_gruppe_2.Controller;

import com.example.projekt3_gruppe_2.Model.Car;
import com.example.projekt3_gruppe_2.Model.Costumer;
import com.example.projekt3_gruppe_2.Model.damageReport;
import com.example.projekt3_gruppe_2.Model.rentalAgreement;
import com.example.projekt3_gruppe_2.Repository.carRepo;
import com.example.projekt3_gruppe_2.Repository.costumerRepo;
import com.example.projekt3_gruppe_2.Repository.damageReportRepo;
import com.example.projekt3_gruppe_2.Repository.rentalAgreementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class carController {

    @Autowired
    carRepo carRepository;

    @Autowired
    rentalAgreementRepo rentalAgreementRepository;

    @Autowired
    costumerRepo costumerRepository;

    @Autowired
    damageReportRepo damageReportRepository;

    @GetMapping("/showCar/{id}")
    public String showCar(@PathVariable("id") int id, Model model) {
        Car car = carRepository.getCarbyId(id);
        
        if (car != null && car.getId() != 0) {
            model.addAttribute("car", car);

            // Fetch rental agreement and customer info if they exist
            if (car.getRentalAgreementId() != null && car.getRentalAgreementId() != 0) {
                rentalAgreement rental = rentalAgreementRepository.getRentalAgreementById(car.getRentalAgreementId());
                if (rental != null) {
                    model.addAttribute("rentalAgreement", rental);

                    if (rental.getCustomerId() != null) {
                        Costumer customer = costumerRepository.getCostumerById(rental.getCustomerId());
                        model.addAttribute("costumer", customer);
                    }
                }
            }

            // Fetch damage report if it exists
            if (car.getDamageReportId() != null && car.getDamageReportId() != 0) {
                damageReport report = damageReportRepository.getDamageReportById(car.getDamageReportId());
                model.addAttribute("damageReport", report);
            }

            return "showCar";
        }
        
        // Redirect to an error or another page if car not found
        return "redirect:/"; 
    }
}
