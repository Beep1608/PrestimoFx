package org.example.clients;

import org.example.clients.dto.ClientCreateDto;
import org.hibernate.Session;

import java.util.List;

public class ClientInteractor {
    private final ClientModel model;
    private final Session session;
    public ClientInteractor(ClientModel model, Session session){
        this.model = model;
        this.session = session;

    }

    public List<ClientCreateDto> suggetions(){
        String hql = "SELECT new org.example.clients.dto.ClientCreateDto(" +
                "c.id, c.name) " +
                "FROM ClientObject c " +
                "ORDER BY c.id ASC";
        var lista = session.createQuery(hql,ClientCreateDto.class).getResultList();
        for (var item : lista){
            System.out.println("Item :"+ item.searcheable());
        }
        return lista;
    }
}
