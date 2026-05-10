package com.example.projekt3_gruppe_2.Model;

public class Car {
    int id;
    String cartNumber;
    String vin;
    String brand;
    String model;
    String color;
    Status status;
    Integer rentalAgreementId;
    Integer damageReportId;

public Car(int id, String cartNumber, String vin, String brand, String model, String color, Status status, Integer rentalAgreementId, Integer damageReportId){
    this.id=id;
    this.cartNumber=cartNumber;
    this.vin=vin;
    this.brand=brand;
    this.model=model;
    this.color=color;
    this.status=status;
    this.rentalAgreementId=rentalAgreementId;
    this.damageReportId=damageReportId;
}

public Car(int id, String cartNumber, String vin, String brand, String model, String color, Status status){
    this(id,cartNumber,vin,brand,model,color,status,null,null);
}

public Car(){}

    public int getId(){
    return id;
    }

    public void setId(int id){
    this.id=id;
    }

    public String getCartNumber() {
        return cartNumber;
    }

    public void setCartNumber(String cartNumber) {
        this.cartNumber = cartNumber;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Integer getRentalAgreementId() {
        return rentalAgreementId;
    }

    public void setRentalAgreementId(Integer rentalAgreementId) {
        this.rentalAgreementId = rentalAgreementId;
    }

    public Integer getDamageReportId() {
        return damageReportId;
    }

    public void setDamageReportId(Integer damageReportId) {
        this.damageReportId = damageReportId;
    }
}


