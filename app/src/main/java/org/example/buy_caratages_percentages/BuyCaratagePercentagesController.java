package org.example.buy_caratages_percentages;

import java.util.HashMap;

import org.hibernate.Session;

import javafx.scene.layout.Region;


public class BuyCaratagePercentagesController{

    private final BuyCaratagePercentagesModel model;
    private final BuyCaratagePercentagesInteractor interactor;
    private final BuyCaratagePercentagesView view;

    public BuyCaratagePercentagesController(Session session){
        this.model = new BuyCaratagePercentagesModel();
        this.interactor = new BuyCaratagePercentagesInteractor(model, session);

        this.view = new BuyCaratagePercentagesView(model, interactor);
        createListeners();
    }

    public Region getView(){
        
        return view.build();
    }

    public BuyCaratagePercentagesModel getModel(){
        return model;
    }


    public void createListeners(){
        model.edit().addListener((observable, oldValue, newValue) -> {
            if(newValue){
                model.create().set(false);
                model.index().set(false);
                interactor.loadDataToEdit();
            }
        });

        model.create().addListener((observable, oldValue, newValue) -> {
            if(newValue){
                model.edit().set(false);
                model.index().set(false);
                interactor.clean();
                interactor.getLast();
            }
        });
    }


}