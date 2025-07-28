package org.example.buy_jewelry;

import java.util.List;

import org.example.buy_caratages_percentages.BuyCaratagePercentagesModel;
import org.example.buy_jewelry.dto.BuyJewelryIndex;
import org.example.buy_percentages.BuyPercentagesModel;
import org.example.constants.ConstantsModel;
import org.example.jewelry.JewelryController;
import org.example.jewelry.JewelryModel;
import org.example.metal_prices.MetalPricesModel;
import org.hibernate.Session;

import javafx.beans.property.BooleanProperty;

public class BuyJewelryInteractor {

    private final BuyJewelryModel model;
    private BuyJewelryObject object;

    //Dendencies
    private Session session;
    private JewelryController jewelryController;
    private BuyCaratagePercentagesModel buyCaratagePercentagesModel;
    private BuyPercentagesModel buyPercentagesModel;
    private MetalPricesModel metalPricesModel;
    private ConstantsModel constantsModel;

    public BuyJewelryInteractor(
            BuyJewelryModel model,
            Session session,
            JewelryController jewelryController,
            BuyCaratagePercentagesModel buyCaratagePercentagesModel,
            BuyPercentagesModel buyPercentagesModel,
            MetalPricesModel metalPricesModel,
            ConstantsModel constantsModel)
    {
        this.model = model;
        this.session = session;
        this.jewelryController = jewelryController;
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

    public void edit(){
        System.out.println("Editando joya.....");
        jewelryController.getInteractor().edit();
        try{
            session.beginTransaction();
            object = session.getReference(BuyJewelryObject.class,model.id().get());
            if(object == null){
                System.out.println("Compra no encontrada con ID: " + model.id().get());
            }
            System.out.println("Compra : "+ object.getId());

            object.setPrice_gr_final(model.price_gr_inter().get());
            object.setRevenue_extern_sale( model.revenue_extern_sale().get());
            object.setPrice_local_gr( model.price_local_gr().get());
            object.setCaratage_price( model.caratage_price().get());
            object.setCaratage_price_final(model.caratage_price_final().get());
            object.setCaratage_price_final_pa(model.caratage_price_final_pa().get());
            object.setPrice_gr_final(model.price_gr_final().get());
            object.setMax_purchase_amount(model.max_purchase_amount().get());
            object.setPercentage_buy_applied(model.percentage_buy_applied().get());
            object.setPercentage_buy_caratage_applied(model.percentage_buy_caratage_applied().get());
            object.setConstants_id(model.constants_id().get());
            object.setMetal_price_id( model.metal_price_id().get());
            object.setPercentages_buy_id(model.percentages_buy_id().get());
            object.setPercentages_buy_caratage_id(model.percentages_caratage_id().get());
            object.setJewelry_id(model.jewelry_id().get());

            session.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("No se pudo actualizar la compra con ID : "+model.id().get());
            e.printStackTrace();
        }

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
                "FROM BuyJewelryObject b JOIN b.jewelry j " +
                "ORDER BY b.id ASC";
        var lista =  session
                .createQuery(hql, BuyJewelryIndex.class)
                .getResultList();
        for (var item : lista){
            System.out.println("Item :"+ item.getWeight());
        }


        return  lista;
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

        System.out.println("Paso [1]: "+ constantsModel.conversion_factor());
        System.out.println("Paso [1]: "+ metalPricesModel.price_onz());
        System.out.println("Paso [1]: "+ model.price_gr_inter());

        //---------

        /**
         *  Paso 2
         */

        model.revenue_extern_sale().set(
                model.price_gr_inter()
                        .subtract(constantsModel.security_value())
                        .get()
        );
        System.out.println("Paso [2]: "+ constantsModel.security_value());
        System.out.println("Paso [2]: "+ model.price_gr_inter());
        System.out.println("Paso [2]: "+ model.revenue_extern_sale());

        //------------------

        /**
         * Paso 3
         */

        model.price_local_gr().set(
                model.revenue_extern_sale()
                        .subtract(constantsModel.revenue_gr())
                        .get()
        );
        System.out.println("Paso [3]: "+ constantsModel.revenue_gr());
        System.out.println("Paso [3]: "+  model.revenue_extern_sale());
        System.out.println("Paso [3]: "+  model.price_local_gr());

        //----------


        /**
         * Paso 4
         */
        model.caratage_price().set(
                model.price_local_gr()
                        .divide(24)
                        .get()
        );

        System.out.println("Paso [4]: "+  model.price_local_gr());
        System.out.println("Paso [4]: "+  model.caratage_price());

        //-------------

        /**
         * Paso 5
         */


        double caratage = Double.parseDouble(
                jewelryController.getModel().caratage().get().replace("K", "")
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
        System.out.println("Paso [5]: "+ model.caratage_price());
        System.out.println("Paso [5]: "+   model.caratage_price_final());
        System.out.println("Paso [5]: "+  caratage);
        System.out.println("Paso [5]: "+ buyCaratagePercentagesModel.selected());
        System.out.println("Paso [5]: "+   model.caratage_price_final());
        System.out.println("Paso [5]: "+  model.caratage_price_final_pa());

        //---------

        /**
         * Paso 6
         */
        model.price_gr_final().set(
                model.caratage_price_final_pa()
                        .multiply(jewelryController.getModel().weight())
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

        System.out.println("Paso [6]: "+ jewelryController.getModel().weight());
        System.out.println("Paso [6]: "+   model.caratage_price_final_pa());
        System.out.println("Paso [6]: "+  model.price_gr_final());
        System.out.println("Paso [6] buyPercentagesModel: "+ buyPercentagesModel.selected());
        System.out.println("Paso [6]: "+   model.price_gr_final());
        System.out.println("Paso [6]: "+   model.max_purchase_amount());

        System.out.println("Paso [6]: "+  buyCaratagePercentagesModel
                .selected());
        System.out.println("Paso [6]: "+    model.percentage_buy_caratage_applied());
        System.out.println("Paso [6]: "+   buyPercentagesModel
                .selected());
        System.out.println("Paso [6]: "+    model.percentage_buy_applied());

        System.out.println("Max amount purchase: "+ model.max_purchase_amount() );
        //id's
        model.constants_id().set(constantsModel.id().get());
        model.metal_price_id().set(metalPricesModel.id().get());
        model.percentages_buy_id().set(buyPercentagesModel.id().get());
        model.percentages_caratage_id().set(buyCaratagePercentagesModel.id().get());
        model.jewelry_id().set(jewelryController.getModel().id().get());

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

    public void loadDataToEdit(int id){
        BuyJewelryObject buy =  findById(id);
        model.id().set(buy.getId());
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

    
}
