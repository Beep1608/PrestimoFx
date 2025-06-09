package org.example.buy_jewelry;

public class BuyJewelryInteractor {

    private final BuyJewelryModel model;
    private BuyJewelryObject object;
    private BuyJewelryService service  = new BuyJewelryService();

    public BuyJewelryInteractor(BuyJewelryModel model){
        this.model = model;
    }
    
}
