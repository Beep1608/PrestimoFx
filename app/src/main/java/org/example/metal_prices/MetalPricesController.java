package org.example.metal_prices;

import org.hibernate.Session;

public class MetalPricesController {
    private final MetalPricesModel model;
    private final MetalPricesInteractor interactor;

    public MetalPricesController(Session session){
        this.model = new MetalPricesModel();
        this.interactor = new MetalPricesInteractor(model, session);
    }

    public MetalPricesModel getModel(){
        return  model;
    }

    public void getLast(){
        interactor.getLast();
    }

    
}
