package org.example.buy_percentages;

import java.util.HashMap;

import org.hibernate.Session;

import javafx.scene.layout.Region;


public class BuyPercentagesController{

    private final BuyPercentagesModel model;
    private final BuyPercentagesInteractor interactor;
    private final BuyPercentageView view;
    private final  HashMap<String, Runnable> actions = new HashMap<>();
    public BuyPercentagesController(Session session){
        this.model = new BuyPercentagesModel();
    
        this.interactor = new BuyPercentagesInteractor(model, session);
        actions.put("getLast", this::getLast);
        actions.put("updateSelected", this::updateSelected);

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

    
    public void updateSelected(){
        interactor.updateSelected(model.selectedString().get());
    }

}