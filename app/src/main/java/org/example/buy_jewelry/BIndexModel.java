package org.example.buy_jewelry;

import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import org.example.buy_jewelry.dto.BuyJewelryIndex;
import org.jenvy.model.IndexModel;

public class BIndexModel extends IndexModel<BuyJewelryIndex> {

    @Override
    protected SimpleListProperty<BuyJewelryIndex> initColumns() {
        SimpleListProperty<BuyJewelryIndex> list = new SimpleListProperty<>();
        return list;
    }

    @Override
    protected SimpleObjectProperty<BuyJewelryIndex>  initDto() {
        return null;
    }
}
