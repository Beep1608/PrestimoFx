package org.example.jewelry;

import org.example.buy_jewelry.BuyJewelryObject;
import org.hibernate.Session;

public class JewelryInteractor {

    private final JewelryModel model;
    private JewelryObject domainObject;
    private JewelryService service;

    private Session session;

    public JewelryInteractor(JewelryModel model, Session session) {
        this.model = model;
        this.service = new JewelryService(session);
        this.session  =session;
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

    public void edit(Integer id){
        
    }

    public JewelryObject findById(int id){
        String query  = "from JewelryObject where id = ?1";
        return session.createSelectionQuery(query, JewelryObject.class)
                .setParameter(1, id)
                .getSingleResult();
    }

    public void loadDataToEdit(int id){
        JewelryObject object = findById(id);

        model.id().set(object.getId());
        model.metal().set(object.getMetal());
        model.caratage().set(object.getCaratage());
        model.weight().set(object.getWeight());
        model.description().set(object.getDescription());
        model.image().set(object.getImage());

    }

    
    
}
