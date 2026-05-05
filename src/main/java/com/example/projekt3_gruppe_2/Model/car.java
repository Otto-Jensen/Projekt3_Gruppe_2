package com.example.projekt3_gruppe_2.Model;

public class car {
    int id;
    String cartNumber;
    String vin;
    String brand;
    String model;
    String color;
    status status;

public car(int id, String cartNumber, String vin, String brand, String model, String color, status status){
    this.id=id;
    this.cartNumber=cartNumber;
    this.vin=vin;
    this.brand=brand;
    this.model=model;
    this.color=color;
    this.status=status;
}

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

    public status getStatus() {
        return status;
    }

    public void setStatus(status status) {
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
}


