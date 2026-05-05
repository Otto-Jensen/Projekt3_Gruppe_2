package com.example.projekt3_gruppe_2.Model;

import java.util.Date;

public class rentalAgreement {
    int id;
    Date startDato;
    Date endDate;
    int price;
    location location;



    public rentalAgreement(int id, Date startDato, Date endDate, int price, location location){
        this.id=id;
        this.startDato=startDato;
        this.endDate=endDate;
        this.price=price;
        this.location=location;
    }

}
