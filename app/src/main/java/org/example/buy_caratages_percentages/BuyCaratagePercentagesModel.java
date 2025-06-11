package org.example.buy_caratages_percentages;


import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BuyCaratagePercentagesModel {

    private final SimpleIntegerProperty id = new SimpleIntegerProperty();

    private final  SimpleDoubleProperty minimum  = new SimpleDoubleProperty();
    private final  SimpleDoubleProperty medium  = new SimpleDoubleProperty();
    private final  SimpleDoubleProperty maximum  = new SimpleDoubleProperty();

    private final SimpleDoubleProperty selected = new SimpleDoubleProperty(0);
    private final SimpleStringProperty selectedString = new SimpleStringProperty();
    
  

    public IntegerProperty id(){
        return  id;
    }

    public DoubleProperty minimum(){
        return minimum;
    }

    public DoubleProperty medium(){
        return medium;
    }

     public DoubleProperty maximum(){
        return maximum;
    }

    public DoubleProperty selected(){
        return  selected;
    }

    public StringProperty selectedString(){
        return  selectedString;
    }
    @Override
    public String toString(){
        return "id : "+id +", minimum: "+minimum +", medium : " + medium +", maximum: "+maximum +" , selected: "+ selected;
    }

}
