package org.example.buy_caratages_percentages;

import org.hibernate.Session;

public class BuyCaratagePercentagesService{
    Session session;

    public BuyCaratagePercentagesService(Session session){
        this.session = session;
    }

    public BuyCaratagePercentagesObject getLast(){
    
           return session.createQuery(
            "FROM percentages_buy_caratage ORDER BY id DESC", BuyCaratagePercentagesObject.class)
                        .setMaxResults(1)
                        .uniqueResult();
    }


}