package org.example.currency_prices;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="currency_prices")
public class CurrencyPricesObject {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private double mxn_value;


    public int getId(){
        return  id;
    }
    public double getMxn_value(){
        return mxn_value;
    }

}
