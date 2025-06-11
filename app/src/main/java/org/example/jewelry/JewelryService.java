package org.example.jewelry;

import org.example.utils.FilesFactory;
import org.hibernate.Session;

public class JewelryService {
    private Session session;
    private String destination = "C:\\prestimo";

    public JewelryService(Session session) {
        this.session = session;
    }

    public JewelryObject store(String metal, String caratage, double weight, String description, String image ) {
        
       
        JewelryObject jewelryObject = new JewelryObject(metal, caratage, weight, description,   FilesFactory.copyLocalFile(image, destination).getAbsolutePath());
        session.beginTransaction();
        session.persist(jewelryObject);
        session.getTransaction().commit();
        System.out.println("Joya registrada exitosamente.");
        return jewelryObject;
    }

    

}
