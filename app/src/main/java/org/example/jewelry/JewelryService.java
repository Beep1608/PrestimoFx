package org.example.jewelry;

import org.hibernate.Session;

public class JewelryService {
    private Session session;

    public JewelryService(Session session) {
        this.session = session;
    }

    public JewelryObject store(String metal, String caratage, double weight, String description) {
        System.out.println("Onichan");
        JewelryObject jewelryObject = new JewelryObject(metal, caratage, weight, description);
        session.beginTransaction();
        session.persist(jewelryObject);
        session.getTransaction().commit();
        System.out.println("Joya registrada exitosamente.");
        return jewelryObject;
    }

}
