package org.example.constants;

import javafx.beans.property.*;

public class ConstantsModel  {

    private  final SimpleIntegerProperty id = new SimpleIntegerProperty();
    private final SimpleDoubleProperty conversion_factor = new SimpleDoubleProperty();
    private final SimpleDoubleProperty security_value = new SimpleDoubleProperty();
    private final SimpleDoubleProperty revenue_gr = new SimpleDoubleProperty();
    private final SimpleBooleanProperty edit = new SimpleBooleanProperty(false);
    private final SimpleBooleanProperty create = new SimpleBooleanProperty(false);
    private final SimpleBooleanProperty index = new SimpleBooleanProperty(false);
   
 
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
    public BooleanProperty create(){
        return create;
    }

    public BooleanProperty edit(){
        return  edit;
    }

    public BooleanProperty index(){
        return  index;
    }

     @Override
    public String toString(){
        return "id : "+id +", conversion_factor: "+conversion_factor +", security_value : " + security_value +", revenue_gr: "+revenue_gr ;
    }



    
}
