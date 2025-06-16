package org.example.jewelry;

import org.example.utils.FilesFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class JewelryService {
    private Session session;
    private String destination = "C:\\prestimo";

    public JewelryService(Session session) {
        this.session = session;
    }

    public JewelryObject store(String metal, String caratage, double weight, String description, String image) {
        Transaction tx = null;
        JewelryObject jewelryObject = null;
        try {
            tx = session.beginTransaction();
            jewelryObject = new JewelryObject(
                metal, caratage, weight, description,
                FilesFactory.copyLocalFile(image, destination).getAbsolutePath()
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
        return jewelryObject;
    }
    

}
