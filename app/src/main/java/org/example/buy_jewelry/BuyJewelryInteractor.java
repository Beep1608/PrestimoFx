package org.example.buy_jewelry;

import java.util.List;

import org.example.buy_caratages_percentages.BuyCaratagePercentagesModel;
import org.example.buy_jewelry.dto.BuyJewelryIndex;
import org.example.buy_percentages.BuyPercentagesModel;
import org.example.constants.ConstantsModel;
import org.example.jewelry.JewelryModel;
import org.example.metal_prices.MetalPricesModel;
import org.hibernate.Session;

import javafx.beans.property.BooleanProperty;

public class BuyJewelryInteractor {

    private final BuyJewelryModel model;
    private BuyJewelryObject object;
    private BuyJewelryService service ;

    public BuyJewelryInteractor(BuyJewelryModel model, Session session){
        this.model = model;
        this.service = new BuyJewelryService(session);
    }

    public void store() {
        System.out.println("Aplicado : "+  model.percentage_buy_caratage_applied().get());
        this.object = service.store( 
            model.price_gr_inter().get(),
            model.revenue_extern_sale().get(),
            model.price_local_gr().get(),
            model.caratage_price().get(),
            model.caratage_price_final().get(),
            model.caratage_price_final_pa().get(),
            model.price_gr_final().get(),
            model.max_purchase_amount().get(),
            model.percentage_buy_applied().get(),
            model.percentage_buy_caratage_applied().get(),
            model.constants_id().get(),
            model.metal_price_id().get(),
            model.percentages_buy_id().get(),
            model.percentages_caratage_id().get(),
            model.jewelry_id().get()
        ); 
    }
    public void show(int id){
        //TODO: Implementar logica para obtener la data de una compra en especifica
    }

    public List<BuyJewelryIndex> index(){
        return service.index();
    }

    public void calculate(
        BuyJewelryModel model,
        JewelryModel jewelryModel,
        BuyCaratagePercentagesModel buyCaratagePercentagesModel,
        BuyPercentagesModel buyPercentagesModel,
        MetalPricesModel metalPricesModel,
        ConstantsModel constantsModel
    )
    {
        service.calculate(model, 
        jewelryModel, 
        buyCaratagePercentagesModel, 
        buyPercentagesModel, 
        metalPricesModel, 
        constantsModel);
    }

    public void makeViewsBindigns(BooleanProperty create, BooleanProperty edit, BooleanProperty index){
        create.addListener((obs, oldVal, newVal) -> {
            if (newVal) {
                edit.set(false);
                index.set(false);
            }
        });

        edit.addListener((obs, oldVal, newVal) -> {
            if (newVal) {
                create.set(false);
                index.set(false);
            }
        });

        index.addListener((obs, oldVal, newVal) -> {
            if (newVal) {
                create.set(false);
                edit.set(false);
            }
        });
    }

    private void loadDataToEdit(){

        if(model.id().get() !=0){

        }
    }

    
}
