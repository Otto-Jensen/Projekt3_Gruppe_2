package com.example.projekt3_gruppe_2.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class damageReport {
    int id;
    Date date;
    List<damage> damages = new ArrayList<>();
    int totalPrice;

    public damageReport(int id, Date date, int totalPrice){
        this.id=id;
        this.date=date;
        this.totalPrice=totalPrice;
        this.damages=new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void addDamage(damage damage){
        damages.add(damage);
    }

    public void removeDamage(damage damage){
        damages.remove(damage);
    }

    public List<damage> getDamages(){
        return damages;
    }

    public void setDamages(List<damage>damages){
        this.damages=damages;
    }
}
