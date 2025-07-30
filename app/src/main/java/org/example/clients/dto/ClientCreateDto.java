package org.example.clients.dto;

import org.jenvy.dto.Dto;

public class ClientCreateDto extends Dto {
    private int id;
    private String name;

    public ClientCreateDto(int id, String name){
        this.id = id;
        this.name = name;
    }
    @Override
    public String searcheable() {
        return name;
    }
}
