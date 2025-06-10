package org.example.buy_percentages;

import org.hibernate.Session;

public class BuyPercentagesService{
    Session session;

    public BuyPercentagesService(Session session){
        this.session = session;
    }

    public BuyPercentageObject getLast(){
    
           return session.createQuery(
            "FROM percentages_buy_caratage ORDER BY id DESC", BuyPercentageObject.class)
                        .setMaxResults(1)
                        .uniqueResult();
    }


}