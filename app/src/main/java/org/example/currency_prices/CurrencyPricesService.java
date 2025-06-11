package org.example.currency_prices;

import org.hibernate.Session;

public class CurrencyPricesService {

    private Session session;

    public CurrencyPricesService(Session session){
        this.session = session;
    }

    public CurrencyPricesObject getLast(){
                  return session.createQuery(
            "FROM CurrencyPricesObject ORDER BY id DESC", CurrencyPricesObject.class)
                        .setMaxResults(1)
                        .uniqueResult();
    }
    
}
