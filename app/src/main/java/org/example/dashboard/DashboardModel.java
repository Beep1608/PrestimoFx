package org.example.dashboard;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableBooleanValue;
import org.jenvy.model.Model;

public class DashboardModel extends Model {

    SimpleBooleanProperty buyView = new SimpleBooleanProperty(true);
    SimpleBooleanProperty loanView = new SimpleBooleanProperty(false);


    public ObservableBooleanValue getBuyViewProperty(){
        return buyView;
    }

    public ObservableBooleanValue getLoanViewProperty(){
        return loanView;
    }
    
}
