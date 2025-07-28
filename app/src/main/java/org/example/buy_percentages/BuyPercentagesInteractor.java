package org.example.buy_percentages;

import org.example.enums.PercentagesEnum;
import org.example.jewelry.JewelryObject;
import org.hibernate.Session;

public class BuyPercentagesInteractor {
    private final BuyPercentagesModel model;
    private Session session;
    private BuyPercentageObject object;

    public BuyPercentagesInteractor(BuyPercentagesModel model, Session session){
        this.model = model;
        this.session = session;
    }

    public BuyPercentageObject getLast(){

        this.object = session.createQuery(
                        "FROM BuyPercentageObject ORDER BY id DESC", BuyPercentageObject.class)
                .setMaxResults(1)
                .uniqueResult();

        model.id().set(object.getId());
        model.minimum().set(object.getMinimum());
        model.medium().set(object.getMedium());
        model.maximum().set(object.getMaximum());
        return object;
    }
     public void updateSelected(){
        var option = model.selectedString().get();
         System.out.println("Actualizando model: "+ model.selectedString());
         if(option.equals("Minimo")){
             model.selected().set(model.minimum().get());
             System.out.println(model.selected());
         }

         if(option.equals("Medio")){
             model.selected().set(model.medium().get());
         }


         if(option.equals("Maximo")){
             model.selected().set(model.maximum().get());
         }
    }

    public BuyPercentageObject findById(int id){
        String query  = "from BuyPercentageObject where id = ?1";
        return session.createSelectionQuery(query, BuyPercentageObject.class)
                .setParameter(1, id)
                .getSingleResult();
    }

    public void loadDataToEdit(){
        try{
            BuyPercentageObject object = findById(model.id().get());
            model.minimum().set(object.getMinimum());
            model.medium().set(object.getMedium());
            model.maximum().set(object.getMaximum());


            if(model.selected().get() == model.minimum().get()){
                model.selectedString().set(PercentagesEnum.MINIMUN.getValue());
            }

            if(model.selected().get() == model.medium().get()){
                model.selectedString().set(PercentagesEnum.MEDIUM.getValue());
            }

            if(model.selected().get() == model.maximum().get()){
                model.selectedString().set(PercentagesEnum.MAXIMUM.getValue());
            }

        }catch (Exception e){
            System.out.println("No pudimos cargar la información de los porcentajes en la compra");
        }
    }

    public void clean(){
        model.id().set(0);
        model.minimum().set(0);
        model.medium().set(0);
        model.maximum().set(0);
        model.selected().set(0);
        model.selectedString().set(null);
    }
}
   