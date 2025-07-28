package org.example.constants;

import org.hibernate.Session;

public class ConstantsController {
    private final ConstantsModel model;
    private final ConstantsInteractor interactor;

    public ConstantsController(Session session){
        this.model = new ConstantsModel();
        this.interactor = new ConstantsInteractor(model, session);
        createListeners();
    }

    public ConstantsModel getModel(){
        return  model;
    }

    public void createListeners(){
        model.edit().addListener((observable, oldValue, newValue) -> {
            if(newValue){
                model.create().set(false);
                interactor.loadDataToEdit();
            }
        });

        model.create().addListener((observable, oldValue, newValue) -> {
            if(newValue){
                model.edit().set(false);
               interactor.getLast();
            }
        });
    }

    
}
