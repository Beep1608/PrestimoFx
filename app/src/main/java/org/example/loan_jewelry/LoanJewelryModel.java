package org.example.loan_jewelry;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class LoanJewelryModel {

    private final SimpleBooleanProperty index = new SimpleBooleanProperty(true);
    private final SimpleBooleanProperty create = new SimpleBooleanProperty(false);


    public BooleanProperty index(){
        return index;
    }

    public BooleanProperty create(){
        return create;
    }
}
