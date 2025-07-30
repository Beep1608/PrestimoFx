package org.example.loan_jewelry;

import org.example.jewelry.JewelryObject;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="loans_jewelry")
public class LoanJewelryObject {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private double price_gr_inter;
    private double revenue_extern_sale;
    private double price_local_gr;
    private double pre_loan_amount;
    private double loan_amount;
    private double final_loan;
    private double percentage_loan_one_applied;
    private double percentage_loan_two_applied;
    private int constants_id;
    private int metal_price_id;
    private int percentages_buy_id;
    private int percentages_buy_caratage_id;

    @ManyToOne
    @JoinColumn(name = "jewelry_id")
    private JewelryObject jewelry;

    public LoanJewelryObject() {

    }
    public LoanJewelryObject(int constants_id){
        this.constants_id =constants_id;
    }

    public LoanJewelryObject(
            double price_gr_inter,
            double revenue_extern_sale,
            double price_local_gr,
            double pre_loan_amount,
            double loan_amount,
            double final_loan,
            double percentage_loan_one_applied,
            double percentage_loan_two_applied,
            int constants_id,
            int metal_price_id,
            int percentages_buy_id,
            int percentages_buy_caratage_id,
            JewelryObject jewelry
    )
    {
        this.price_gr_inter = price_gr_inter;
        this.revenue_extern_sale = revenue_extern_sale;
        this.price_local_gr = price_local_gr;
        this.pre_loan_amount = pre_loan_amount;
        this.loan_amount = loan_amount;
        this.final_loan = final_loan;
        this.percentage_loan_one_applied = percentage_loan_one_applied;
        this.percentage_loan_two_applied = percentage_loan_two_applied;
        this.constants_id = constants_id;
        this.metal_price_id = metal_price_id;
        this.percentages_buy_id = percentages_buy_id;
        this.percentages_buy_caratage_id = percentages_buy_caratage_id;
        this.jewelry = jewelry;

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

    public double getPre_loan_amount() {
        return pre_loan_amount;
    }

    public void setPre_loan_amount(double pre_loan_amount) {
        this.pre_loan_amount = pre_loan_amount;
    }

    public double getLoan_amount() {
        return loan_amount;
    }

    public void setLoan_amount(double loan_amount) {
        this.loan_amount = loan_amount;
    }

    public double getFinal_loan() {
        return final_loan;
    }

    public void setFinal_loan(double final_loan) {
        this.final_loan = final_loan;
    }

    public double getPercentage_loan_one_applied() {
        return percentage_loan_one_applied;
    }

    public void setPercentage_loan_one_applied(double percentage_loan_one_applied) {
        this.percentage_loan_one_applied = percentage_loan_one_applied;
    }

    public double getPercentage_loan_two_applied() {
        return percentage_loan_two_applied;
    }

    public void setPercentage_loan_two_applied(double percentage_loan_two_applied) {
        this.percentage_loan_two_applied = percentage_loan_two_applied;
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

    public JewelryObject getJewelry() {
        return jewelry;
    }

    public void setJewelry(JewelryObject jewelry) {
        this.jewelry = jewelry;
    }

    public int getJewelry_id() {
        return jewelry != null ? jewelry.getId() : 0;
    }

    public void setJewelry_id(int jewelry_id) {
        if (this.jewelry == null) {
            this.jewelry = new JewelryObject();
        }
        this.jewelry.setId(jewelry_id);
    }
    @Override
    public String toString() {
        return "LoanJewelryObject{" +
                "id=" + id +
                ", price_gr_inter=" + price_gr_inter +
                ", revenue_extern_sale=" + revenue_extern_sale +
                ", price_local_gr=" + price_local_gr +
                ", pre_loan_amount=" + pre_loan_amount +
                ", loan_amount=" + loan_amount +
                ", final_loan=" + final_loan +
                ", percentage_loan_one_applied=" + percentage_loan_one_applied +
                ", percentage_loan_two_applied=" + percentage_loan_two_applied +
                ", constants_id=" + constants_id +
                ", metal_price_id=" + metal_price_id +
                ", percentages_buy_id=" + percentages_buy_id +
                ", percentages_buy_caratage_id=" + percentages_buy_caratage_id +
                ", jewelry_id=" + getJewelry_id() +
                '}';
    }

}
