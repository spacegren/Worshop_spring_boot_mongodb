package com.nicaciopereira.workshopmongo.dto;

import com.nicaciopereira.workshopmongo.domain.User;

import java.io.Serializable;

public class AutorDto implements Serializable {
    private static final long serialVersionUID = 1l;
    private String id;
    private String name;

    public AutorDto(){

    }
    public AutorDto(User obj){
        id = obj.getId();
        name = obj.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
