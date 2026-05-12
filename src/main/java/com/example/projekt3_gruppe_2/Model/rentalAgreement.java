package com.example.projekt3_gruppe_2.Model;

import java.util.Date;

public class rentalAgreement {
    int id;
    Date startDato;
    Date endDate;
    int price;
    Location location;
    Integer customerId;



    public rentalAgreement(int id, Date startDato, Date endDate, int price,Location location, Integer customerId){
        this.id=id;
        this.startDato=startDato;
        this.endDate=endDate;
        this.price=price;
        this.location=location;
        this.customerId=customerId;
    }

    public rentalAgreement(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public int getprice() {
        return price;
    }

    public void setPrice(int price) {
        this.price=price;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDato() {
        return startDato;
    }

    public void setStartDato(Date startDato) {
        this.startDato = startDato;
    }
}
