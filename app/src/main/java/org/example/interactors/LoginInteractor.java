package org.example.interactors;

import org.example.App;
import org.example.entity.UserEntity;
import org.jenvy.interactor.Interactor;

public class LoginInteractor extends Interactor {

    public void login(String email, String password){

        if(loginOffline()){
            System.out.println("Se encontró usuario");
        }


    }

    private boolean loginOffline(){
        UserEntity user = App.session.find(UserEntity.class,1L);
        System.out.println("User :"+ user);
        if(user != null){
            System.out.println("User :"+ user.getId());
            System.out.println("User :"+ user.getUsername());
            System.out.println("User :"+ user.getEmail());
        }
        return user != null;
    }

    private void loginOnline(){

    }
}
