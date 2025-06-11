package org.example.metal_prices;

import org.hibernate.Session;

public class MetalPricesService {
    private Session session;
    public MetalPricesService(Session session){
        this.session = session;
    }

    public MetalPricesObject getLast(){
        
           return session.createQuery(
            "FROM MetalPricesObject ORDER BY id DESC", MetalPricesObject.class)
                        .setMaxResults(1)
                        .uniqueResult();
    }
}
