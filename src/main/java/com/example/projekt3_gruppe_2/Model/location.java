package com.example.projekt3_gruppe_2.Model;

public enum location {
   ADRESS1("DIRCHSVEJ 50"),
    ADRESS2("MARKEN 3"),
    ADRESS("SIDEMARKEN 4");

    private final String adress;

   location(String adress){
       this.adress=adress;
   }

   public String getAdress(){
       return adress;
   }
}
