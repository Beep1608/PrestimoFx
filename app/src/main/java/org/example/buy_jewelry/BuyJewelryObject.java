package org.example.buy_jewelry;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="buys_jewelry")
public class BuyJewelryObject {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private double price_gr_inter;
    private double revenue_extern_sale;
    private double price_local_gr;
    private double caratage_price;
    private double caratage_price_final;
    private double caratage_price_final_pa;
    private double price_gr_final;
    private double max_purchase_amount;
    private double percentage_buy_applied;
    private double percentage_buy_caratage_applied;
    private int constants_id;
    private int metal_price_id;
    private int percentages_buy_id;
    private int percentages_buy_caratage_id;
    private int jewelry_id;
    public BuyJewelryObject() {

    }

    public BuyJewelryObject(
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
    )
    {
        this.price_gr_inter = price_gr_inter;
        this.revenue_extern_sale = revenue_extern_sale;
        this.price_local_gr = price_local_gr;
        this.caratage_price = caratage_price;
        this.caratage_price_final = caratage_price_final;
        this.caratage_price_final_pa = caratage_price_final_pa;
        this.price_gr_final = price_gr_final;
        this.max_purchase_amount = max_purchase_amount;
        this.percentage_buy_applied = percentage_buy_applied;
        this.percentage_buy_caratage_applied = percentage_buy_caratage_applied;
        this.constants_id = constants_id;
        this.metal_price_id = metal_price_id;
        this.percentages_buy_id = percentages_buy_id;
        this.percentages_buy_caratage_id = percentages_buy_caratage_id;
        this.jewelry_id = jewelry_id;

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice_gr_inter() {
        return price_gr_inter;
    }

    public void setPrice_gr_inter(double price_gr_inter) {
        this.price_gr_inter = price_gr_inter;
    }

    public double getRevenue_extern_sale() {
        return revenue_extern_sale;
    }

    public void setRevenue_extern_sale(double revenue_extern_sale) {
        this.revenue_extern_sale = revenue_extern_sale;
    }

    public double getPrice_local_gr() {
        return price_local_gr;
    }

    public void setPrice_local_gr(double price_local_gr) {
        this.price_local_gr = price_local_gr;
    }

    public double getCaratage_price() {
        return caratage_price;
    }

    public void setCaratage_price(double caratage_price) {
        this.caratage_price = caratage_price;
    }

    public double getCaratage_price_final() {
        return caratage_price_final;
    }

    public void setCaratage_price_final(double caratage_price_final) {
        this.caratage_price_final = caratage_price_final;
    }

        public double getCaratage_price_final_pa() {
        return caratage_price_final_pa;
    }

    public void setCaratage_price_final_pa(double caratage_price_final_pa) {
        this.caratage_price_final_pa = caratage_price_final_pa;
    }

    public double getPrice_gr_final() {
        return price_gr_final;
    }

    public void setPrice_gr_final(double price_gr_final) {
        this.price_gr_final = price_gr_final;
    }

    public double getMax_purchase_amount() {
        return max_purchase_amount;
    }

    public void setMax_purchase_amount(double max_purchase_amount) {
        this.max_purchase_amount = max_purchase_amount;
    }

    public double getPercentage_buy_applied() {
        return percentage_buy_applied;
    }

    public void setPercentage_buy_applied(double percentage_buy_applied) {
        this.percentage_buy_applied = percentage_buy_applied;
    }

    public double getPercentage_buy_caratage_applied() {
        return percentage_buy_caratage_applied;
    }

    public void setPercentage_buy_caratage_applied(double percentage_buy_caratage_applied) {
        this.percentage_buy_caratage_applied = percentage_buy_caratage_applied;
    }

    public int getConstants_id() {
        return constants_id;
    }

    public void setConstants_id(int constants_id) {
        this.constants_id = constants_id;
    }

    public int getMetal_price_id() {
        return metal_price_id;
    }

    public void setMetal_price_id(int metal_price_id) {
        this.metal_price_id = metal_price_id;
    }

    public int getPercentages_buy_id() {
        return percentages_buy_id;
    }

    public void setPercentages_buy_id(int percentages_buy_id) {
        this.percentages_buy_id = percentages_buy_id;
    }

    public int getPercentages_buy_caratage_id() {
        return percentages_buy_caratage_id;
    }

    public void setPercentages_buy_caratage_id(int percentages_buy_caratage_id) {
        this.percentages_buy_caratage_id = percentages_buy_caratage_id;
    }

    public int getJewelry_id() {
        return jewelry_id;
    }

    public void setJewelry_id(int jewelry_id) {
        this.jewelry_id = jewelry_id;
    }



}
