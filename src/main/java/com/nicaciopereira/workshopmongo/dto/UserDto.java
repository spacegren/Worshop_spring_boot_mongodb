package com.nicaciopereira.workshopmongo.dto;

import com.nicaciopereira.workshopmongo.domain.User;

import java.io.Serializable;

public class UserDto implements Serializable {
    private static final long serialVersionUID = 1l;

    private String id;
    private String name;
    private String email;

    public UserDto(){

    }
    public UserDto(User obj){
        id = obj.getId();
        email = obj.getEmail();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
