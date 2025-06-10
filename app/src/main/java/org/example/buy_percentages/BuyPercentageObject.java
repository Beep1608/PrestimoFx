package org.example.buy_percentages;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="percentages_buy")
public class BuyPercentageObject {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private double minimum;
    private double medium;
    private double maximum;


    public int getId(){
        return  id;
    }

    public double getMinimum(){
        return  minimum;
    }

    public double getMedium(){
        return  medium;
    }
    public double getMaximum(){
        return  maximum;
    }
}
