package org.example.buy_caratages_percentages;

import org.hibernate.Session;

public class BuyCaratagePercentagesInteractor {
    private final BuyCaratagePercentagesModel model;
    private  BuyCaratagePercentagesObject object;
    private  BuyCaratagePercentagesService service;

    public BuyCaratagePercentagesInteractor(BuyCaratagePercentagesModel model, Session session){
        this.model = model;
        this.service = new BuyCaratagePercentagesService(session);
    }

    public BuyCaratagePercentagesObject getLast(){

        this.object  = (BuyCaratagePercentagesObject) service.getLast();
        model.id().set(object.getId());
        model.minimum().set(object.getMinimum());
        model.medium().set(object.getMedium());
        model.maximum().set(object.getMaximum());
        return object;
    }
}
   