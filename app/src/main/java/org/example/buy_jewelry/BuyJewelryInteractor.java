package org.example.buy_jewelry;

import org.hibernate.Session;

public class BuyJewelryInteractor {

    private final BuyJewelryModel model;
    private BuyJewelryObject object;
    private BuyJewelryService service ;

    public BuyJewelryInteractor(BuyJewelryModel model, Session session){
        this.model = model;
        this.service = new BuyJewelryService(session);
    }

    public void store() {
        this.object = service.store( 
            model.price_gr_inter().get(),
            model.revenue_extern_sale().get(),
            model.price_local_gr().get(),
            model.caratage_price().get(),
            model.caratage_price_final().get(),
            model.price_gr_final().get(),
            model.max_purchase_amount().get(),
            model.image().get(),
            model.percentage_buy_applied().get(),
            model.percentage_buy_caratage_applied().get(),
            model.constants_id().get(),
            model.metal_price_id().get(),
            model.percentages_buy_id().get(),
            model.percentages_caratage_id().get(),
            model.jewelry_id().get()
        ); 
    }

    
}
