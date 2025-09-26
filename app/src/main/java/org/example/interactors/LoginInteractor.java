package org.example.interactors;

import javafx.scene.Node;
import org.example.App;
import org.example.entity.UserEntity;
import org.example.models.LoginModel;
import org.jenvy.interactor.Interactor;

public class LoginInteractor extends Interactor {

    private LoginModel model;

    public LoginInteractor(LoginModel model){
        this.model = model;
    }

    public boolean login(String email, String password){

        if(App.offline){
            return loginOffline();
        }

        return false;
    }

    private boolean loginOffline(){
        UserEntity user = App.session.find(UserEntity.class,1L);
        model.user().set(user);
        return user != null;
    }

    private void loginOnline(){

    }
}
