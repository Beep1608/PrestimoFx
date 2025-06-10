package org.example.constants;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="constants")
public class ConstantsObject {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private double conversion_factor;
    private double security_value;
    private double revenue_gr;
    

    public int getId(){
        return  id;
    }

    public double getConversion_factor(){
        return  conversion_factor;
    }


    public double getSecurity_value(){
        return  security_value;
    }

    public double getRevenue_gr(){
        return  revenue_gr;
    }
}
