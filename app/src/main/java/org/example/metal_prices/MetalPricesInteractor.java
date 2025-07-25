package org.example.metal_prices;

import org.example.buy_percentages.BuyPercentageObject;
import org.hibernate.Session;

public class MetalPricesInteractor {

    private final MetalPricesModel model;

    private MetalPricesObject object;

    private Session session;

    public MetalPricesInteractor(MetalPricesModel model, Session session){
        this.model = model;
        this.session = session;
    }

    public MetalPricesObject getLast(){
        this.object =  session.createQuery(
                        "FROM MetalPricesObject ORDER BY id DESC", MetalPricesObject.class)
                .setMaxResults(1)
                .uniqueResult();

        model.id().set(object.getId());
        model.metal().set(object.getMetal());
        model.price_onz().set(object.getPrice_onz());
        model.price_gr().set(object.getPrice_gr());
        model.currency_prices_id().set(object.getCurrency_prices_id());

        return object;
    }
    public MetalPricesObject findById(int id){
        String query  = "from MetalPricesObject where id = ?1";
        return session.createSelectionQuery(query, MetalPricesObject.class)
                .setParameter(1, id)
                .getSingleResult();
    }

    public void loadDataToEdit(){
        try {
            MetalPricesObject object = findById(model.id().get());
            model.metal().set(object.getMetal());
            model.price_onz().set(object.getPrice_onz());
            model.price_gr().set(object.getPrice_gr());
            model.currency_prices_id().set(object.getCurrency_prices_id());
        }catch (Exception e){
            System.out.println("No pudimos cargar la información de los metales");
        }
    }
    
}
