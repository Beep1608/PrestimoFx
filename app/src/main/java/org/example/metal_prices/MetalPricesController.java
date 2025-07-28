package org.example.metal_prices;

import org.hibernate.Session;

public class MetalPricesController {
    private final MetalPricesModel model;
    private final MetalPricesInteractor interactor;

    public MetalPricesController(Session session){
        this.model = new MetalPricesModel();
        this.interactor = new MetalPricesInteractor(model, session);
        createListeners();
    }

    public MetalPricesModel getModel(){
        return  model;
    }

    public void getLast(){
        interactor.getLast();
    }

    public void createListeners(){
        model.edit().addListener((observable, oldValue, newValue) -> {
            if(newValue){
                model.create().set(false);
                interactor.loadDataToEdit();
            }
        });

        model.create().addListener((observable, oldValue, newValue) -> {
            if(newValue){
                model.edit().set(false);
                interactor.getLast();
            }
        });
    }

    
}
