package org.example.buy_percentages;


import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class BuyPercentagesModel {

    private final SimpleIntegerProperty id = new SimpleIntegerProperty();

    private final  SimpleDoubleProperty minimum  = new SimpleDoubleProperty();
    private final  SimpleDoubleProperty medium  = new SimpleDoubleProperty();
    private final  SimpleDoubleProperty maximum  = new SimpleDoubleProperty();
    
    private final SimpleDoubleProperty selected = new SimpleDoubleProperty(0);
    public BuyPercentagesModel(){
        
    }

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

}
