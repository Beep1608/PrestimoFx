package org.example.metal_prices;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="metal_prices")
public class MetalPricesObject {
    

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String metal;
    private double  price_onz;
    private double price_gr;
    private int currency_prices_id; 


    public int getId(){
        return  id;
    }

    public String getMetal(){
        return  metal;
    }

    public double getPrice_onz(){
        return  price_onz;
    }

    public double  getPrice_gr(){
        return  price_gr;
    }

    public int getCurrency_prices_id(){
        return  currency_prices_id;
    }
}
