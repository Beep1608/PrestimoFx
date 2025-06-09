package org.example.jewelry;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class JewelryObject {
    @Id
    private int id;

    @NotNull
    private String metal;
    
    @NotNull
    private String caratage;
    
    @NotNull
    private double weight;
    
    @NotNull
    private String description;

    public JewelryObject() {
        
    }
    public JewelryObject(String metal, String caratage, double weight, String description) {
        this.metal = metal;
        this.caratage = caratage;
        this.weight = weight;
        this.description = description;
    }
    public String getMetal() {
        return metal;
    }
    public void setMetal(String metal) {
        this.metal = metal;
    }
    public String getCaratage() {
        return caratage;
    }
    public void setCaratage(String caratage) {
        this.caratage = caratage;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }



    
}
