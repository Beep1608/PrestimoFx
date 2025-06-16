package org.example.buy_jewelry;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BuyJewelryModel {

    private final SimpleDoubleProperty price_gr_inter = new SimpleDoubleProperty(); // 1 
    private final SimpleDoubleProperty revenue_extern_sale = new SimpleDoubleProperty();
    private final SimpleDoubleProperty price_local_gr = new SimpleDoubleProperty();
    private final SimpleDoubleProperty caratage_price = new SimpleDoubleProperty();
    private final SimpleDoubleProperty caratage_price_final = new SimpleDoubleProperty();
    private final SimpleDoubleProperty caratage_price_final_pa = new SimpleDoubleProperty();
    private final SimpleDoubleProperty price_gr_final = new SimpleDoubleProperty();
    private final SimpleDoubleProperty max_purchase_amount = new SimpleDoubleProperty();
    private final SimpleStringProperty image = new SimpleStringProperty();
    private final SimpleDoubleProperty percentage_buy_applied = new SimpleDoubleProperty();
    private final SimpleDoubleProperty percentage_buy_caratage_applied = new SimpleDoubleProperty();
    private final SimpleIntegerProperty metal_price_id = new SimpleIntegerProperty();
    private final SimpleIntegerProperty percentages_buy_id = new SimpleIntegerProperty();
    private final SimpleIntegerProperty percentages_caratage_id = new SimpleIntegerProperty();
    private final SimpleIntegerProperty contants_id = new SimpleIntegerProperty();
    private final SimpleIntegerProperty jewelry_id = new SimpleIntegerProperty();






    // public void calculate(){
    //     /**Paso 1 */
    //     price_gr_inter.set(
    //         metalPricesModel.price_gr().divide(
    //             constantsModel.conversion_factor()
    //         ).get()
    //     );
    //     /*****/

    //     /**Paso 2 */
    //     revenue_extern_sale.set(
    //         price_gr_inter.subtract(
    //             constantsModel.security_value()
    //         ).get()
    //     );
    //     /*****/

    //     /**Paso 3 */

    //     price_local_gr.set(
    //         revenue_extern_sale.subtract(
    //            constantsModel.revenue_gr()
    //         ).get()
    //     );
    //     /*****/ 

    //     /**Paso 4 */
    //     caratage_price.set(
    //         price_local_gr.divide(
    //           24
    //         ).get()
    //     );
    //     /*****/

    //     /**Paso 5 */
    //     int caratage = Integer.parseInt( jewelryModel.caratage().get().replace("k", ""));
    //     caratage_price_final.set(
    //         caratage_price.multiply(
    //            caratage
    //         ).multiply(percentage_buy_caratage_applied).get()
    //     );
    //     /*****/

    //     /**Paso 6 */

    //     price_gr_final.set(
    //         jewelryModel.weight().multiply(
    //             caratage_price_final
    //         ).get()
    //     );
    //     /*****/

    //     /**Paso 7 */
    //     max_purchase_amount.set(
    //         price_gr_final.multiply(
    //             percentage_buy_applied
    //         ).get()
    //     );
    //     /*****/
    // }


    public DoubleProperty price_gr_inter(){
        return  price_gr_inter;
    }

    public DoubleProperty revenue_extern_sale(){
        return  revenue_extern_sale;
    }

    public DoubleProperty price_local_gr(){
        return price_local_gr;
    }

    public DoubleProperty caratage_price(){
        return caratage_price;
    }

    public DoubleProperty caratage_price_final(){
        return caratage_price_final;
    }
    
    public DoubleProperty caratage_price_final_pa(){
        return caratage_price_final_pa;
    }

    public DoubleProperty price_gr_final(){
        return price_gr_final;
    }

    public DoubleProperty max_purchase_amount(){
        return  max_purchase_amount;
    }

    public StringProperty image(){
        return  image;
    } 

    public DoubleProperty percentage_buy_applied() {
        return percentage_buy_applied;
    }
    public DoubleProperty percentage_buy_caratage_applied() {
        return percentage_buy_caratage_applied;
    }

    public IntegerProperty metal_price_id(){
        return metal_price_id;
    }

    public IntegerProperty percentages_buy_id(){
        return percentages_buy_id;
    }

    public IntegerProperty percentages_caratage_id (){
        return percentages_caratage_id;
    }

    public IntegerProperty constants_id(){
        return contants_id;
    }

    public IntegerProperty jewelry_id() {
        return jewelry_id;
    }
}
