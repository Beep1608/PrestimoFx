package org.example.buy_jewelry;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BuyJewelryModel {

    private final SimpleIntegerProperty id = new SimpleIntegerProperty(0);

    private final SimpleDoubleProperty price_gr_inter = new SimpleDoubleProperty(); // 1 
    private final SimpleDoubleProperty revenue_extern_sale = new SimpleDoubleProperty();
    private final SimpleDoubleProperty price_local_gr = new SimpleDoubleProperty();
    private final SimpleDoubleProperty caratage_price = new SimpleDoubleProperty();
    private final SimpleDoubleProperty caratage_price_final = new SimpleDoubleProperty();
    private final SimpleDoubleProperty caratage_price_final_pa = new SimpleDoubleProperty();
    private final SimpleDoubleProperty price_gr_final = new SimpleDoubleProperty();
    private final SimpleDoubleProperty max_purchase_amount = new SimpleDoubleProperty();
    private final SimpleStringProperty image = new SimpleStringProperty();
    private final SimpleDoubleProperty percentage_buy_applied = new SimpleDoubleProperty();
    private final SimpleDoubleProperty percentage_buy_caratage_applied = new SimpleDoubleProperty();
    private final SimpleIntegerProperty metal_price_id = new SimpleIntegerProperty();
    private final SimpleIntegerProperty percentages_buy_id = new SimpleIntegerProperty();
    private final SimpleIntegerProperty percentages_caratage_id = new SimpleIntegerProperty();
    private final SimpleIntegerProperty contants_id = new SimpleIntegerProperty();
    private final SimpleIntegerProperty jewelry_id = new SimpleIntegerProperty();

    private final SimpleBooleanProperty calculate = new SimpleBooleanProperty(false);

    private final SimpleBooleanProperty edit = new SimpleBooleanProperty(false);
    private final SimpleBooleanProperty create = new SimpleBooleanProperty(false);
    private final SimpleBooleanProperty index = new SimpleBooleanProperty(true);

    public DoubleProperty price_gr_inter(){
        return  price_gr_inter;
    }

    public DoubleProperty revenue_extern_sale(){
        return  revenue_extern_sale;
    }

    public DoubleProperty price_local_gr(){
        return price_local_gr;
    }

    public DoubleProperty caratage_price(){
        return caratage_price;
    }

    public DoubleProperty caratage_price_final(){
        return caratage_price_final;
    }
    
    public DoubleProperty caratage_price_final_pa(){
        return caratage_price_final_pa;
    }

    public DoubleProperty price_gr_final(){
        return price_gr_final;
    }

    public DoubleProperty max_purchase_amount(){
        return  max_purchase_amount;
    }

    public StringProperty image(){
        return  image;
    } 

    public DoubleProperty percentage_buy_applied() {
        return percentage_buy_applied;
    }
    public DoubleProperty percentage_buy_caratage_applied() {
        return percentage_buy_caratage_applied;
    }

    public IntegerProperty metal_price_id(){
        return metal_price_id;
    }

    public IntegerProperty percentages_buy_id(){
        return percentages_buy_id;
    }

    public IntegerProperty percentages_caratage_id (){
        return percentages_caratage_id;
    }

    public IntegerProperty constants_id(){
        return contants_id;
    }

    public IntegerProperty jewelry_id() {
        return jewelry_id;
    }

    public BooleanProperty calculate(){
        return calculate;
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

    public IntegerProperty id(){
        return  id;
    }
}
