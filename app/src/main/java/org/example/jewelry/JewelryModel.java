package org.example.jewelry;

import org.example.buy_jewelry.BuyJewelryModel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class JewelryModel  {
   
    private final SimpleStringProperty metal = new SimpleStringProperty();
    private final SimpleStringProperty caratage = new SimpleStringProperty();
    private final SimpleDoubleProperty weight = new SimpleDoubleProperty();
    private final SimpleStringProperty description = new SimpleStringProperty();

    private final SimpleDoubleProperty buy_percentage = new SimpleDoubleProperty();
    private final SimpleDoubleProperty caratage_percentage = new SimpleDoubleProperty();
    


    public JewelryModel() {
        super();
        
    }
    
    

    public StringProperty metal() {
        return metal;
    }
    public SimpleStringProperty caratage() {
        return caratage;
    }
    public SimpleDoubleProperty weight() {
        return weight;
    }
    public SimpleStringProperty description() {
        return description;
    }
    public SimpleDoubleProperty buyPercentage() {
        return buy_percentage;
    }

    public SimpleDoubleProperty caratagePercentage() {
        return caratage_percentage;
    }

}
