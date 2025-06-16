package org.example.buy_jewelry;

import org.hibernate.Session;

public class BuyJewelryService {

    private Session session;

    public BuyJewelryService(Session session){
        this.session = session;
    }
    
    public BuyJewelryObject store(
        double price_gr_inter,
        double revenue_extern_sale,
        double price_local_gr,
        double caratage_price,
        double caratage_price_final,
        double caratage_price_final_pa,
        double price_gr_final,
        double max_purchase_amount,
        double percentage_buy_applied,
        double percentage_buy_caratage_applied,
        int constants_id,
        int metal_price_id,
        int percentages_buy_id,
        int percentages_buy_caratage_id,
        int jewelry_id
        
    ) {
      
        BuyJewelryObject object = new BuyJewelryObject(
            price_gr_inter, 
            revenue_extern_sale, 
            price_local_gr, 
            caratage_price, 
            caratage_price_final, 
            caratage_price_final_pa,
            price_gr_final, 
            max_purchase_amount, 
            percentage_buy_applied, 
            percentage_buy_caratage_applied, 
            constants_id, 
            metal_price_id, 
            percentages_buy_id, 
            percentages_buy_caratage_id, 
            jewelry_id
        );

        session.beginTransaction();
        session.persist(object);
        session.getTransaction().commit();


        return  object;
        
    }
}
