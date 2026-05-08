package com.example.projekt3_gruppe_2.Model;

public class damage {
    int id;
    String description;
    int price;
    Integer damageReportId;

    public damage(int id, String description, int price, Integer damageReportId){
        this.id=id;
        this.description=description;
        this.price=price;
        this.damageReportId=damageReportId;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDamageReportId() {
        return damageReportId;
    }

    public void setDamageReportId(Integer damageReportId) {
        this.damageReportId = damageReportId;
    }
}
