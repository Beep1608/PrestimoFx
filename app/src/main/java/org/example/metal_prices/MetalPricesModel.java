package org.example.metal_prices;

import javafx.beans.property.*;

public class MetalPricesModel {

    private final SimpleIntegerProperty id = new SimpleIntegerProperty();

    private final SimpleStringProperty metal = new SimpleStringProperty();
    private final SimpleDoubleProperty price_onz  = new SimpleDoubleProperty();
    private final SimpleDoubleProperty price_gr  = new SimpleDoubleProperty();
    private final SimpleIntegerProperty currency_prices_id = new SimpleIntegerProperty();
    private final SimpleBooleanProperty edit = new SimpleBooleanProperty(false);
    private final SimpleBooleanProperty create = new SimpleBooleanProperty(false);
    private final SimpleBooleanProperty index = new SimpleBooleanProperty(false);

    public IntegerProperty id(){
        return  id;
    }

    public StringProperty metal(){
        return  metal;
    }

    public DoubleProperty price_onz(){
        return  price_onz;
    }

    public DoubleProperty price_gr(){
        return price_gr;
    }

    public IntegerProperty currency_prices_id(){
        return currency_prices_id;
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
        return "id : "+id +", metal: "+metal +", price_onz : " + price_onz +", price_gr: "+price_gr +", currency_prices_id: "+currency_prices_id;
    }
    
}
