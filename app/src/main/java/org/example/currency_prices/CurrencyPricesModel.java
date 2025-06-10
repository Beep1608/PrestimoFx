package org.example.currency_prices;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class CurrencyPricesModel {
    
    private final SimpleIntegerProperty id = new SimpleIntegerProperty();
    private final SimpleDoubleProperty mxn_value = new SimpleDoubleProperty();


    public IntegerProperty id(){
        return id;
    }

    public DoubleProperty mxn_value(){
        return mxn_value;
    }


}
