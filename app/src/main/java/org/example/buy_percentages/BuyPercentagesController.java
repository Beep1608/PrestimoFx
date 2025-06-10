package org.example.buy_percentages;

import java.util.HashMap;
import java.util.function.Consumer;

import org.hibernate.Session;

import javafx.scene.layout.Region;


public class BuyPercentagesController{

    private final BuyPercentagesModel model;
    private final BuyPercentagesInteractor interactor;
    private final BuyPercentageView view;
    private final  HashMap<String, Consumer<Void>> actions = new HashMap<>();
    public BuyPercentagesController(Session session){
        this.model = new BuyPercentagesModel();
    
        this.interactor = new BuyPercentagesInteractor(model, session);


        this.view = new BuyPercentageView(model, actions);
    }
    public Region getView(){
        return  view.build();
    }

    public BuyPercentagesModel getModel(){
        return model;
    }

    public void getLast(){
        interactor.getLast();
    }

}