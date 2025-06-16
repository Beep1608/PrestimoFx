package org.example.buy_percentages;

import org.hibernate.Session;

public class BuyPercentagesService{
    Session session;

    public BuyPercentagesService(Session session){
        this.session = session;
    }

    public BuyPercentageObject getLast(){
            
           return session.createQuery(
            "FROM BuyPercentageObject ORDER BY id DESC", BuyPercentageObject.class)
                        .setMaxResults(1)
                        .uniqueResult();
    }
    public void updateSelected(String option, BuyPercentagesModel model){

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