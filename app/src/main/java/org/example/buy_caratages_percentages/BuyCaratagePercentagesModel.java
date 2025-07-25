package org.example.buy_caratages_percentages;


import javafx.beans.property.*;

public class BuyCaratagePercentagesModel {

    private final SimpleIntegerProperty id = new SimpleIntegerProperty();

    private final  SimpleDoubleProperty minimum  = new SimpleDoubleProperty();
    private final  SimpleDoubleProperty medium  = new SimpleDoubleProperty();
    private final  SimpleDoubleProperty maximum  = new SimpleDoubleProperty();

    private final SimpleDoubleProperty selected = new SimpleDoubleProperty(0);
    private final SimpleStringProperty selectedString = new SimpleStringProperty();


    private final SimpleBooleanProperty edit = new SimpleBooleanProperty(false);
    private final SimpleBooleanProperty create = new SimpleBooleanProperty(false);
    private final SimpleBooleanProperty index = new SimpleBooleanProperty(false);

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
        return "id : "+id +", minimum: "+minimum +", medium : " + medium +", maximum: "+maximum +" , selected: "+ selected;
    }

}
