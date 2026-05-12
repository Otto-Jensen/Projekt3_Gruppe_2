package com.example.projekt3_gruppe_2.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class damageReport {
    int id;
    Date date;
    List<Damage> Damages = new ArrayList<>();
    int totalPrice;

    public damageReport(int id, Date date, int totalPrice){
        this.id=id;
        this.date=date;
        this.totalPrice=totalPrice;
        this.Damages =new ArrayList<>();
    }

    public damageReport(){

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

    public void addDamage(Damage damage){
        Damages.add(damage);
    }

    public void removeDamage(Damage damage){
        Damages.remove(damage);
    }

    public List<Damage> getDamages(){
        return Damages;
    }

    public void setDamages(List<Damage> Damages){
        this.Damages = Damages;
    }
}
