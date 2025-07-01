package org.example.jewelry.dto;

public class JewelryEditDto {
    private int id;
    private String metal;
    private String weight;
    private String caratage;
    private String description;
    private String image;
    
    public JewelryEditDto(
        int id, 
        String metal, 
        String weight, 
        String caratage, 
        String description, 
        String image
    ) {
        this.id = id;
        this.metal = metal;
        this.weight = weight;
        this.caratage = caratage;
        this.description = description;
        this.image = image;
    }


    public int getId(){
        return  id;
    }

    public String getMetal(){
        return  metal;
    }

}
