package org.example.jewelry;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="jewelries")
public class JewelryObject {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

  
    private String metal;
    
   
    private String caratage;
    
  
    private double weight;
    
   
    private String description;

    private String image;

    public JewelryObject() {
        
    }
    public JewelryObject(String metal, String caratage, double weight, String description, String image) {
        this.metal = metal;
        this.caratage = caratage;
        this.weight = weight;
        this.description = description;
        this.image = image;
    }

    public int getId(){
        return  id;
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

    public void setImage(String image){
        this.image = image;
    }
    public String getImage(){
        return image;
    }



    
}
