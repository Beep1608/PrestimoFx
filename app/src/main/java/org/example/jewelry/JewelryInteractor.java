package org.example.jewelry;

import org.example.buy_jewelry.BuyJewelryObject;
import org.example.utils.FilesFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class JewelryInteractor {

    private final JewelryModel model;
    private JewelryObject object;

    private Session session;
    private String destination = "C:\\prestimo";

    public JewelryInteractor(JewelryModel model, Session session) {
        this.model = model;
        this.session  =session;
    }

    public JewelryObject store() {
        Transaction tx = null;
        JewelryObject jewelryObject = null;
        try {
            tx = session.beginTransaction();
            jewelryObject = new JewelryObject(
                    model.metal().get(),
                    model.caratage().get(),
                    model.weight().get(),
                    model.description().get(),
                    FilesFactory.copyLocalFile(model.image().get(), destination).getAbsolutePath()
            );

            session.persist(jewelryObject);
            tx.commit();
            System.out.println("Joya registrada exitosamente.");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            jewelryObject = null;
        }
        System.out.println("El ID es: "+jewelryObject.getId());
        model.id().set(jewelryObject.getId());
        return jewelryObject;



    }

    public void edit(){
        try{
            session.beginTransaction();
            object = session.getReference(JewelryObject.class,model.id().get());
            if(object == null){
                System.out.println("Joya no encontrada  con ID : "+ model.id().get());
                return;
            }

            object.setMetal(model.metal().get());
            object.setCaratage(model.caratage().get());
            object.setWeight(model.weight().get());
            object.setDescription(model.description().get());


            if (model.image().get() != null || !model.image().get().equals("")) {
                String newImagePath = FilesFactory.copyLocalFile(model.image().get(), destination).getAbsolutePath();
                object.setImage(newImagePath);
                System.out.println("Imagen en el interactor : "+ newImagePath);
            }

            session.getTransaction().commit();

        }catch (Exception e){
            System.out.println("No se pudo actualizar la joya con ID :"+ model.id().get());
        }
    }

    public JewelryObject findById(int id){
        String query  = "from JewelryObject where id = ?1";
        return session.createSelectionQuery(query, JewelryObject.class)
                .setParameter(1, id)
                .getSingleResult();
    }

    public void loadDataToEdit(int id){
        JewelryObject object = findById(id);

        model.id().set(object.getId());
        model.metal().set(object.getMetal());
        model.caratage().set(object.getCaratage());
        model.weight().set(object.getWeight());
        model.description().set(object.getDescription());
        model.image().set(object.getImage());

    }

    public void clean(){
        model.id().set(0);
        model.metal().set(null);
        model.caratage().set(null);
        model.weight().set(0);
        model.description().set(null);
        model.image().set(null);
    }

    
    
}
