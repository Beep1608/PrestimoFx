package org.example.jewelry;

import java.util.HashMap;
import java.util.function.Consumer;

import javafx.beans.binding.Bindings;
import org.hibernate.Session;

import javafx.scene.layout.Region;

public class JewelryController {
    private final JewelryModel model;
    private final JewelryInteractor interactor;
    private final JewelryView view;
  //  private final JewelryIndexView indexView;
     private final JewelryCreateView createView;

    public JewelryController(Session session) {
        this.model = new JewelryModel();
        this.interactor = new JewelryInteractor(model ,session);
        this.createView = new JewelryCreateView(model,interactor);
       // this.indexView = new JewelryIndexView();
        this.view = new JewelryView(model, createView.build());

        createBindings();
        createListeners();
    }   

    
    public Region getView() {
        return view.build();
    }

    public JewelryModel getModel(){
        return  model;
    }

    public JewelryInteractor getInteractor(){
        return interactor;
    }

    protected void createBindings(){
        createView.build().visibleProperty().bind(
                Bindings.or(model.create(), model.edit())
        );

    }

    protected void createListeners(){

        model.create().addListener((observable, oldValue, newValue) -> {
            if(newValue){
               model.index().set(false);
               model.edit().set(false);

               try{
                   System.out.println("Limpiando joyería");
                interactor.clean();
                createView.imageForm.stopPreview();
               }catch (Exception e){
                   System.out.println("Lo sentimos pero el modelo no puede limpiarse.");
               }

            }
        });

        model.edit().addListener((observable, oldValue, newValue) -> {
            if(newValue){
                model.create().set(false);
                model.index().set(false);
                try {
                    interactor.loadDataToEdit(model.id().get());
                }catch (Exception e){
                    System.out.println("Lo sentimos pero el modelo no tiene un id.");
                }

            }
        });

        model.index().addListener((observable, oldValue, newValue) -> {
            if(newValue){
                model.create().set(false);
                model.edit().set(false);
            }
        });
    }





}
