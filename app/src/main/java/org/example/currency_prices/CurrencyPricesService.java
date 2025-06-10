package org.example.currency_prices;

import org.hibernate.Session;

public class CurrencyPricesService {

    private Session session;

    public CurrencyPricesService(Session session){
        this.session = session;
    }

    public CurrencyPricesObject getLast(){
                  return session.createQuery(
            "FROM percentages_buy_caratage ORDER BY id DESC", CurrencyPricesObject.class)
                        .setMaxResults(1)
                        .uniqueResult();
    }
    
}
