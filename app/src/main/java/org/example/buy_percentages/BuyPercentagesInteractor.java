package org.example.buy_percentages;

import org.hibernate.Session;

public class BuyPercentagesInteractor {
    private final BuyPercentagesModel model;
    private BuyPercentageObject object;
    private BuyPercentagesService service;

    public BuyPercentagesInteractor(BuyPercentagesModel model, Session session){
        this.model = model;
        this.service = new BuyPercentagesService(session);
    }

    public BuyPercentageObject getLast(){

        this.object  = (BuyPercentageObject) service.getLast();
        model.id().set(object.getId());
        model.minimum().set(object.getMinimum());
        model.medium().set(object.getMedium());
        model.maximum().set(object.getMaximum());
        return object;
    }
}
   