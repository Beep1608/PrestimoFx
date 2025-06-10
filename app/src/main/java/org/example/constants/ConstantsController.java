package org.example.constants;

import org.hibernate.Session;

public class ConstantsController {
    private final ConstantsModel model;
    private final ConstantsInteractor interactor;

    public ConstantsController(Session session){
        this.model = new ConstantsModel();
        this.interactor = new ConstantsInteractor(model, session);
    }

    public ConstantsModel getModel(){
        return  model;
    }

    public void getLast(){
        interactor.getLast();
    }

    
}
