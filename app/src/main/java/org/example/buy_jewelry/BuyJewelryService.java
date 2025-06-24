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
        System.out.println(object);
        session.beginTransaction();
        session.persist(object);
        session.getTransaction().commit();


        return  object;
        
    }

    public List<BuyJewelryIndex> index() {
        String hql = "SELECT new org.example.buy_jewelry.dto.BuyJewelryIndex(" +
             "b.id, b.max_purchase_amount, " +
             "CAST(j.weight AS string), j.caratage, j.description) " +
             "FROM BuyJewelryObject b JOIN b.jewelry j";
        return  session
                .createQuery(hql, BuyJewelryIndex.class)
                .getResultList();
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
}
