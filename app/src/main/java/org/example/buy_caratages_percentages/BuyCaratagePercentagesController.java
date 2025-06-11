package org.example.buy_caratages_percentages;

import java.util.HashMap;

import org.hibernate.Session;

import javafx.scene.layout.Region;


public class BuyCaratagePercentagesController{

    private final BuyCaratagePercentagesModel model;
    private final BuyCaratagePercentagesInteractor interactor;
    private final BuyCaratagePercentagesView view;
    private final  HashMap<String, Runnable> actions = new HashMap<>();
    public BuyCaratagePercentagesController(Session session){
        this.model = new BuyCaratagePercentagesModel();
        this.interactor = new BuyCaratagePercentagesInteractor(model, session);
        actions.put("getLast", this::getLast);
        actions.put("updateSelected", this::updateSelected);
        this.view = new BuyCaratagePercentagesView(model, actions);
        //createListeners();
    }

    public Region getView(){
        
        return view.build();
    }

    public BuyCaratagePercentagesModel getModel(){
        return model;
    }

    public void getLast(){
        interactor.getLast();
    }

    public void updateSelected(){
        interactor.updateSelected(model.selectedString().get());
    }

    
}