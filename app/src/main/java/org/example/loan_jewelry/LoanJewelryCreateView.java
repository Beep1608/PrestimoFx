package org.example.loan_jewelry;

import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.util.Builder;
import org.jenvy.components.FormView;

public class LoanJewelryCreateView extends FormView {

    private final LoanJewelryModel model;
    private final LoanJewelryInteractor interactor;
    private Region clientView;
    public LoanJewelryCreateView(LoanJewelryModel model,
                                 LoanJewelryInteractor interactor,
                                 Region clientView){
        super();
        this.model = model;
        this.interactor = interactor;
        this.clientView = clientView;
        makeView();

    }

    @Override
    protected void addFieldsToGeneralDataContainer() {

        generalDataCotainer.getContentContainer().setSpacing(10);
        generalDataCotainer
                .getContentContainer()
                .getChildren()
                .addAll(clientView);
    }

    @Override
    protected void addFieldsToSpecialDataContainer() {

    }

    @Override
    protected void addActionsToCreateButton() {

    }

    @Override
    protected void addActionsToBackButton() {

    }

}
