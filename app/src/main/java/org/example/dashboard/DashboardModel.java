package org.example.dashboard;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableBooleanValue;

public class DashboardModel {

    SimpleBooleanProperty buyView = new SimpleBooleanProperty(false);
    SimpleBooleanProperty loanView = new SimpleBooleanProperty(false);


    public ObservableBooleanValue getBuyViewProperty(){
        return buyView;
    }

    public ObservableBooleanValue getLoanViewProperty(){
        return loanView;
    }
    
}
