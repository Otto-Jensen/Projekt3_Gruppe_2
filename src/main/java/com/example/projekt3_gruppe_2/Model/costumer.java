package com.example.projekt3_gruppe_2.Model;

public class costumer {
    int id;
    String name;
    int phoneNumber;
    String email;

    public costumer(int id, String name, int phoneNumber, String email){
        this.id=id;
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.email=email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
