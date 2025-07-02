package org.example.buy_jewelry;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import org.example.buy_jewelry.dto.BuyJewelryIndex;
import org.jenvy.view.IndexView;

import javafx.scene.layout.Region;

import java.util.List;

public class BIndexView extends IndexView<BuyJewelryIndex>{

    public BIndexView(BIndexModel model){
        super(model);
    }
  
    @Override
    public Region build() {
        return new Region();
    }

    @Override
    protected List<TableColumn<BuyJewelryIndex, Object>> createColumns() {
        return List.of();
    }

    @Override
    protected Button editButton() {
        Button btn = new Button("Editar");
        btn.setOnAction(evt ->{
            System.out.println("Hola");
        });
        return btn;
    }

}
