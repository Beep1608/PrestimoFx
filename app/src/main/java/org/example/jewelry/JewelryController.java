package org.example.jewelry;

import java.util.HashMap;
import java.util.function.Consumer;

import org.hibernate.Session;

import javafx.concurrent.Task;
import javafx.scene.layout.Region;

public class JewelryController {
    private final JewelryModel model;
    private final JewelryInteractor interactor;
    private final JewelryView view;
    private final  HashMap<String, Consumer<Void>> actions = new HashMap<>();

    public JewelryController(Session session) {
        this.model = new JewelryModel();
        this.interactor = new JewelryInteractor(model ,session);
        this.actions.put("store", this::store);
        this.view = new JewelryView(model,actions);
    }   

    
    public Region getView() {
        return view.build();
    }

    public JewelryModel getModel(){
        return  model;
    }

    //TODO: implementar logica de guardado
    public  void store(Void unused) {
        System.out.println("Guardando joya...");
         interactor.store();
                
        // Task<Void> task = new Task<Void>() {
        //     @Override
        //     protected Void call() throws Exception {
                
        //         interactor.store();
                
        //         return null;
        //     }
        // };

        // task.setOnSucceeded(evt -> {
        //     System.out.println("Joya registrada exitosamente.");
        // });

        // Thread saveThread = new Thread(task);
        // saveThread.start();
    }


}
