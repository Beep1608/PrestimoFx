package org.example.dashboard;

import org.example.buy_caratages_percentages.BuyCaratagePercentagesController;
import org.example.buy_jewelry.BuyJewelryController;
import org.example.buy_percentages.BuyPercentagesController;
import org.example.constants.ConstantsController;
import org.example.jewelry.JewelryController;
import org.example.loan_jewelry.LoanJewelryController;
import org.example.metal_prices.MetalPricesController;
import org.hibernate.Session;

import javafx.scene.layout.Region;
import org.jenvy.model.Model;
import org.jenvy.view.router.DefaultPageProvider;
import org.jenvy.view.router.Page;

import java.util.HashMap;
import java.util.Map;

public class DashboardController {
    private final DashboardModel model;
    private final DashboardInteractor interactor;
    private final DashboardView view;
    private final DashboardService service;

    //Controllers
    private final BuyJewelryController buyJewelryController;
    private final LoanJewelryController loanJewelryController;
    private final JewelryController jewelryController;
    private final BuyPercentagesController buyPercentagesController;
    private final BuyCaratagePercentagesController buyCaratagePercentagesController;
    private final MetalPricesController metalPricesController;
    private final ConstantsController constantsController;

    public DashboardController(Session session) {
        this.model = new DashboardModel();
        this.jewelryController = new JewelryController(session);
        this.buyPercentagesController = new BuyPercentagesController(session);
        this.buyCaratagePercentagesController = new BuyCaratagePercentagesController(session);
        this.metalPricesController = new MetalPricesController(session);
        this.constantsController = new ConstantsController(session);

        this.buyJewelryController = new BuyJewelryController(
            jewelryController, 
            buyPercentagesController,
            buyCaratagePercentagesController,
            metalPricesController,
            constantsController,
            session
        );
        this.loanJewelryController = new LoanJewelryController(session);

        this.view = new DashboardView(model, buyJewelryController.getView(), loanJewelryController.getView());
        this.interactor = new DashboardInteractor(model);
        this.service = new DashboardService();

        createBindings();
    }

    public Region getView() {
        return view;
    }


    private void createBindings(){
        buyJewelryController.getView().visibleProperty().bind(model.buyView);
        loanJewelryController.getView().visibleProperty().bind(model.loanView);
    }

    // Other methods to handle user actions and update the view
    
}
