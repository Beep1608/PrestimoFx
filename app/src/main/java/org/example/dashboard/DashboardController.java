package org.example.dashboard;

import org.example.buy_jewelry.BuyJewelryController;
import org.example.jewelry.JewelryController;
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
    public DashboardController(Session session) {
        this.model = new DashboardModel();
        this.jewelryController = new JewelryController(session);
        this.buyJewelryController = new BuyJewelryController( jewelryController.getView());
        
        this.view = new DashboardView(model, buyJewelryController.getView());
        this.interactor = new DashboardInteractor(model);
        this.service = new DashboardService();
    }

    public Region getView() {
        return view.build();
    }



    // Other methods to handle user actions and update the view
    
}
