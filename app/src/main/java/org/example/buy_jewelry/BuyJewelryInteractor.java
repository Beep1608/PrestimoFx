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

    //Dendencies
    private Session session;
    private JewelryModel jewelryModel;
    private BuyCaratagePercentagesModel buyCaratagePercentagesModel;
    private BuyPercentagesModel buyPercentagesModel;
    private MetalPricesModel metalPricesModel;
    private ConstantsModel constantsModel;

    public BuyJewelryInteractor(
            BuyJewelryModel model,
            Session session,
            JewelryModel jewelryModel,
            BuyCaratagePercentagesModel buyCaratagePercentagesModel,
            BuyPercentagesModel buyPercentagesModel,
            MetalPricesModel metalPricesModel,
            ConstantsModel constantsModel)
    {
        this.model = model;
        this.session = session;
        this.jewelryModel = jewelryModel;
        this.buyCaratagePercentagesModel = buyCaratagePercentagesModel;
        this.buyPercentagesModel = buyPercentagesModel;
        this.metalPricesModel = metalPricesModel;
        this.constantsModel = constantsModel;
    }

    public BuyJewelryObject store() {
        System.out.println("Aplicado : "+  model.percentage_buy_caratage_applied().get());
        BuyJewelryObject object = new BuyJewelryObject(
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
        System.out.println(object);
        session.beginTransaction();
        session.persist(object);
        session.getTransaction().commit();
        return  object;
    }
    public BuyJewelryObject findById(int id){

        String query  = "from BuyJewelryObject where id = ?1";
        return session.createSelectionQuery(query,BuyJewelryObject.class)
                .setParameter(1, id)
                .getSingleResult();
    }

    public List<BuyJewelryIndex> index(){
        String hql = "SELECT new org.example.buy_jewelry.dto.BuyJewelryIndex(" +
                "b.id, b.max_purchase_amount, " +
                "CAST(j.weight AS string), j.caratage, j.description) " +
                "FROM BuyJewelryObject b JOIN b.jewelry j";
        return  session
                .createQuery(hql, BuyJewelryIndex.class)
                .getResultList();
    }

    public void calculate()
    {
        /**
         * Paso 1
         */

        model.price_gr_inter().set(
                metalPricesModel.price_onz()
                        .divide(constantsModel.conversion_factor())
                        .get()
        );

        //---------

        /**
         *  Paso 2
         */

        model.revenue_extern_sale().set(
                model.price_gr_inter()
                        .subtract(constantsModel.security_value())
                        .get()
        );

        //------------------

        /**
         * Paso 3
         */

        model.price_local_gr().set(
                model.revenue_extern_sale()
                        .subtract(constantsModel.revenue_gr())
                        .get()
        );

        //----------


        /**
         * Paso 4
         */
        model.caratage_price().set(
                model.price_local_gr()
                        .divide(24)
                        .get()
        );

        //-------------

        /**
         * Paso 5
         */


        double caratage = Double.parseDouble(
                jewelryModel.caratage().get().replace("K", "")
        );
        model.caratage_price_final().set(
                model.caratage_price()
                        .multiply(caratage)
                        .get()
        );

        model.caratage_price_final_pa().set(
                model.caratage_price_final()
                        .multiply(buyCaratagePercentagesModel.selected())
                        .get()
        );

        //---------

        /**
         * Paso 6
         */
        model.price_gr_final().set(
                model.caratage_price_final_pa()
                        .multiply(jewelryModel.weight())
                        .get()
        );
        model.max_purchase_amount().set(
                model.price_gr_final()
                        .multiply(buyPercentagesModel.selected())
                        .get()
        );

        model.percentage_buy_caratage_applied().set(
                buyCaratagePercentagesModel
                        .selected()
                        .get()
        );
        model.percentage_buy_applied().set(
                buyPercentagesModel
                        .selected()
                        .get()
        );

        //id's
        model.constants_id().set(constantsModel.id().get());
        model.metal_price_id().set(metalPricesModel.id().get());
        model.percentages_buy_id().set(buyPercentagesModel.id().get());
        model.percentages_caratage_id().set(buyCaratagePercentagesModel.id().get());
        model.jewelry_id().set(jewelryModel.id().get());

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
    
    public void show(int id){
        BuyJewelryObject buy =  findById(id);
        
        model.max_purchase_amount().set(buy.getMax_purchase_amount());
        model.price_gr_inter().set(buy.getPrice_gr_inter());
        model.revenue_extern_sale().set(buy.getRevenue_extern_sale());
        model.price_local_gr().set(buy.getPrice_local_gr());
        model.caratage_price().set(buy.getCaratage_price());
        model.caratage_price_final_pa().set(buy.getCaratage_price_final_pa());
        model.price_gr_final().set(buy.getPrice_gr_final());
        model.percentage_buy_applied().set(buy.getPercentage_buy_applied());
        model.percentage_buy_caratage_applied().set(buy.getPercentage_buy_caratage_applied());
        model.metal_price_id().set(buy.getMetal_price_id());
        model.percentages_buy_id().set(buy.getPercentages_buy_id());
        model.percentages_caratage_id().set(buy.getPercentages_buy_caratage_id());
        model.constants_id().set(buy.getConstants_id());
        model.jewelry_id().set(buy.getJewelry_id());

    }

    private void loadDataToEdit(){

    }

    
}
