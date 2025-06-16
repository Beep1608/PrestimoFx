package org.example.buy_caratages_percentages;

import org.hibernate.Session;

public class BuyCaratagePercentagesService{
    Session session;

    public BuyCaratagePercentagesService(Session session){
        this.session = session;
    }

    public BuyCaratagePercentagesObject getLast(){
           return session.createQuery(
            "FROM BuyCaratagePercentagesObject ORDER BY id DESC", BuyCaratagePercentagesObject.class)
                        .setMaxResults(1)
                        .uniqueResult();
    }

    public void updateSelected(String option, BuyCaratagePercentagesModel model){

        if(option.equals("Minimo")){
            model.selected().set(model.minimum().get());
        }

        if(option.equals("Medio")){
             model.selected().set(model.medium().get());
        }


        if(option.equals("Maximo")){
             model.selected().set(model.maximum().get());
        }
    }


}