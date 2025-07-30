package org.example.loan_jewelry;

import javafx.scene.layout.Region;
import org.example.clients.ClientController;
import org.example.loan_jewelry.index.LoanJewelryIndexModel;
import org.example.loan_jewelry.index.LoanJewelryIndexView;
import org.hibernate.Session;

public class LoanJewelryController {

        private final LoanJewelryModel model;
        private final LoanJewelryInteractor interactor;
        private final LoanJewelryView view;

        //Index
        private final LoanJewelryIndexModel indexModel;
        private final LoanJewelryIndexView indexView;

        //Create
        private final LoanJewelryCreateView createView;

        //Dependencies
        private final ClientController clientController;

        public LoanJewelryController(Session session){

            this.clientController = new ClientController(session);

            this.model = new LoanJewelryModel();
            this.interactor = new LoanJewelryInteractor(session);

            this.indexModel = new LoanJewelryIndexModel();
            this.indexView =new LoanJewelryIndexView(indexModel, interactor);

            this.createView = new LoanJewelryCreateView(model, interactor,clientController.getView());

            this.view = new LoanJewelryView(model,indexView.build(),createView.build());
            createBindings();
            createListeners();
            createActions();
        }

        public Region getView(){
            return view.build();
        }

        private void createBindings(){
            indexView.build().visibleProperty().bind(model.index());
            createView.build().visibleProperty().bind(model.create());
        }
        private void createListeners(){
            model.index().addListener((observable, oldValue, newValue) -> {
                if(newValue){
                    model.create().set(false);
                }
            });

            model.create().addListener((observable, oldValue, newValue) -> {
                if(newValue){
                    System.out.println("Create mostrandose");
                    clientController.getModel().create().set(true);
                    model.index().set(false);
                }
            });
        }

        private void createActions(){
            indexView.getEditButton().setOnAction(event -> {
                model.create().set(true);
            });

            indexView.getCreateButton().setOnAction(event -> {
                model.create().set(true);
            });
        }




}
