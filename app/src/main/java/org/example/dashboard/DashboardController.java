package org.example.dashboard;

import org.example.buy_caratages_percentages.BuyCaratagePercentagesController;
import org.example.buy_jewelry.BuyJewelryController;
import org.example.buy_percentages.BuyPercentagesController;
import org.example.constants.ConstantsController;
import org.example.jewelry.JewelryController;
import org.example.metal_prices.MetalPricesController;
import org.hibernate.Session;

import javafx.scene.layout.Region;

public class DashboardController {
    private final DashboardModel model;
    private final DashboardInteractor interactor;
    private final DashboardView view;
    private final DashboardService service;

    //Controllers
    private final BuyJewelryController buyJewelryController;
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
        
        this.view = new DashboardView(model, buyJewelryController.getView());
        this.interactor = new DashboardInteractor(model);
        this.service = new DashboardService();
    }

    public Region getView() {
        return view.build();
    }



    // Other methods to handle user actions and update the view
    
}
