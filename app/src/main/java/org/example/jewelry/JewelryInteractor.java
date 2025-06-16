package org.example.jewelry;

import org.hibernate.Session;

public class JewelryInteractor {

    private final JewelryModel model;
    private JewelryObject domainObject;
    private JewelryService service;

    public JewelryInteractor(JewelryModel model, Session session) {
        this.model = model;
        this.service = new JewelryService(session);
    }

    public void store() {
    
       domainObject = service.store(
        model.metal().get(),
        model.caratage().get(), 
        model.weight().get(), 
        model.description().get(),
        model.image().get()
       );

       model.id().set(domainObject.getId());

    }

    
    
}
