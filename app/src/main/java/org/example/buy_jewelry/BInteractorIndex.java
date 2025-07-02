package org.example.buy_jewelry;

import javafx.collections.FXCollections;
import org.example.buy_jewelry.dto.BuyJewelryIndex;
import org.hibernate.Session;
import org.jenvy.interactor.Interactor;
import org.jenvy.model.Model;

import java.util.List;

public class BInteractorIndex extends Interactor {
    private final BIndexModel model ;
    private Session session;
    public BInteractorIndex(BIndexModel model) {
        this.model = model;

    }

    public void setSession(Session session){
        this.session = session;
    }

    public void index() {
        String hql = "SELECT new org.example.buy_jewelry.dto.BuyJewelryIndex(" +
                "b.id, b.max_purchase_amount, " +
                "CAST(j.weight AS string), j.caratage, j.description) " +
                "FROM BuyJewelryObject b JOIN b.jewelry j";

        List<BuyJewelryIndex> result = session
                .createQuery(hql, BuyJewelryIndex.class)
                .getResultList();

        model.elements().set(FXCollections.observableArrayList(result));
    }
}
