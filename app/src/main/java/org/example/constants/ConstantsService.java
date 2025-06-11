package org.example.constants;

import org.hibernate.Session;

public class ConstantsService {
    private Session session;

    public ConstantsService(Session session){
        this.session = session;
    }

    public ConstantsObject getLast(){
            
        return session.createQuery(
        "FROM ConstantsObject ORDER BY id DESC", ConstantsObject.class)
                    .setMaxResults(1)
                    .uniqueResult();
    }
    
}
