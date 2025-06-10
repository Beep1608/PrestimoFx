package org.example.metal_prices;

import org.hibernate.Session;

public class MetalPricesInteractor {

    private final MetalPricesModel model;

    private MetalPricesObject object;
    private MetalPricesService service;

    public MetalPricesInteractor(MetalPricesModel model, Session session){
        this.model = model;
        this.service = new MetalPricesService(session);
    }

    public void getLast(){
        this.object = service.getLast();

        model.id().set(object.getId());
        model.metal().set(object.getMetal());
        model.price_onz().set(object.getPrice_onz());
        model.price_gr().set(object.getPrice_gr());
        model.currency_prices_id().set(object.getCurrency_prices_id());
    }
    
}
