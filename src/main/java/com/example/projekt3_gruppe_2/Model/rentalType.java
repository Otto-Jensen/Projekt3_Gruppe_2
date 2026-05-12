package com.example.projekt3_gruppe_2.Model;

public enum rentalType {
    QUARTERLY(5000),
    SEMIANNUALLY(8000),
    ANNUALLY(14000);

    private final int price;

    rentalType(int price){
        this.price=price;
    }

    public int getPrice(){
        return price;
    }
}
