package org.example.constants;

import org.hibernate.Session;

public class ConstantsInteractor {
    private final ConstantsModel model;
    private ConstantsObject object;
    private ConstantsService service;

    public ConstantsInteractor(ConstantsModel model, Session session){
        this.model = model;
        this.service = new ConstantsService(session);
    }

    public void getLast(){
        this.object = service.getLast();
        model.conversion_factor().set(object.getConversion_factor());
        model.security_value().set(object.getSecurity_value());
        model.revenue_gr().set(object.getRevenue_gr());
    }
    
    
}
