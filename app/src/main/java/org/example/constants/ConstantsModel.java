package org.example.constants;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class ConstantsModel  {

    private  final SimpleIntegerProperty id = new SimpleIntegerProperty();
    private final SimpleDoubleProperty conversion_factor = new SimpleDoubleProperty();
    private final SimpleDoubleProperty security_value = new SimpleDoubleProperty();
    private final SimpleDoubleProperty revenue_gr = new SimpleDoubleProperty();
   
 
    public DoubleProperty conversion_factor() {
        return conversion_factor;
    }
    public DoubleProperty security_value() {
        return security_value;
    }
    public DoubleProperty revenue_gr() {
        return revenue_gr;
    }

    public IntegerProperty id(){
        return id;
    }

     @Override
    public String toString(){
        return "id : "+id +", conversion_factor: "+conversion_factor +", security_value : " + security_value +", revenue_gr: "+revenue_gr ;
    }



    
}
