package org.example.loan_jewelry;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.util.Builder;
import org.jenvy.dto.Dto;
import org.jenvy.model.IndexModel;
import org.jenvy.view.IndexView;

import java.util.List;

public class LoanJewelryView implements Builder<Region>{

    private final LoanJewelryModel model;
    private final StackPane container;

    public LoanJewelryView(LoanJewelryModel model, Region index, Region create){
        this.model = model;
        this.container  =new StackPane(index,create);
    }

    @Override
    public Region build() {
        return container;
    }
}
