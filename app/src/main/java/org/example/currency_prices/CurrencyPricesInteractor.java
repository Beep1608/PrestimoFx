package org.example.currency_prices;

import org.hibernate.Session;

public class CurrencyPricesInteractor {
    private final CurrencyPricesModel model;
    private CurrencyPricesObject object;
    private CurrencyPricesService service;


    public CurrencyPricesInteractor(CurrencyPricesModel model,Session session){
        this.model = model;
        this.service  = new CurrencyPricesService(session); 
    }


    public void getLast(){
        this.object  = service.getLast();
        model.id().set(object.getId());
        model.mxn_value().set(object.getMxn_value());
    }
    
    
}
