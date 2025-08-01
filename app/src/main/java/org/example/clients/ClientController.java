package org.example.clients;

import javafx.collections.FXCollections;
import javafx.scene.layout.Region;
import org.hibernate.Session;

public class ClientController {

    private final ClientModel model;
    private final ClientInteractor interactor;
    private final ClientView view;

    //Create
    private final ClientCreateView createView;


    public ClientController(Session session){
        this.model = new ClientModel();
        this.interactor = new ClientInteractor(model,session);
        this.createView = new ClientCreateView(model,interactor);
        this.view = new ClientView(model,interactor,createView.build());
        createListeners();
        createBindings();
    }

    public Region getView(){
        return view.build();
    }

    public ClientModel getModel(){
        return model;
    }

    private void createListeners(){
        model.create().addListener((observable, oldValue, newValue) -> {
            if(newValue){
                model.index().set(false);
                model.suggestions().set(FXCollections.observableList( interactor.suggetions()));

            }
        });
    }

    private void createBindings(){
        createView.build().visibleProperty().bind(model.create());
    }
}
