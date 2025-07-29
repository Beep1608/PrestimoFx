package org.example.constants;

import org.example.buy_percentages.BuyPercentageObject;
import org.hibernate.Session;

public class ConstantsInteractor {
    private final ConstantsModel model;
    private ConstantsObject object;
    private Session session;

    public ConstantsInteractor(ConstantsModel model, Session session){
        this.model = model;
        this.session = session;
    }

    public ConstantsObject getLast(){
        this.object =session.createQuery(
                        "FROM ConstantsObject ORDER BY id DESC", ConstantsObject.class)
                .setMaxResults(1)
                .uniqueResult();

        model.id().set(object.getId());
        model.conversion_factor().set(object.getConversion_factor());
        model.security_value().set(object.getSecurity_value());
        model.revenue_gr().set(object.getRevenue_gr());
        return  object;
    }

    public ConstantsObject findById(int id){
        String query  = "from ConstantsObject where id = ?1";
        return session.createSelectionQuery(query, ConstantsObject.class)
                .setParameter(1, id)
                .getSingleResult();
    }

    public void loadDataToEdit(){
        try {
            ConstantsObject object = findById(model.id().get());
            model.conversion_factor().set(object.getConversion_factor());
            model.security_value().set(object.getSecurity_value());
            model.revenue_gr().set(object.getRevenue_gr());

        }catch (Exception e){
            System.out.println("No pudimos cargar la información de las constantes");
        }
    }



}
