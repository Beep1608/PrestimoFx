package org.example.buy_jewelry.dto;

import org.jenvy.dto.Dto;

public class BuyJewelryIndex extends Dto {
 
    private int id; //BuyJewelryObject
    private double amount;//BuyJewelryObject
    private String weight; //JewelryObject
    private String caratage; //JewelryObject
    private String description; //JewelryObject

    public BuyJewelryIndex(int id, double amount, String weight, String caratage, String description){

        this.id = id;
        this.amount = amount;
        this.weight = weight;
        this.caratage = caratage;
        this.description = description;

    }

    public int getId(){
        return  id;
    }
    public void setId(int id){
        this.id = id;
    }
    public double getAmount(){
        return  amount;
    }
    public void setAmount(double amount){
        this.amount = amount;
    }
    public String getWeight(){
        return weight;
    }
    public void setWeight(String weight){   
        this.weight = weight;
    }
    public String getCaratage(){
        return caratage;
    }
     public void setCaratage(String caratage){
        this.caratage = caratage;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
         this.description = description;
    }

}
