package org.example.buy_jewelry;

import org.hibernate.Session;
import org.jenvy.controller.IndexController;
import org.jenvy.interactor.Interactor;
import org.jenvy.model.IndexModel;
import org.jenvy.view.IndexView;

public class BIndexController extends IndexController<BIndexModel,BIndexView, BInteractorIndex> {

    public BIndexController(Session session){
        super();
        interactor.setSession(session);
    }

    @Override
    protected BIndexView initView() {
        return new BIndexView(model);
    }

    @Override
    protected BIndexModel initModel() {
       return new BIndexModel();
    }

    @Override
    protected BInteractorIndex initInteractor() {
        return new BInteractorIndex(model);
    }

    

}
