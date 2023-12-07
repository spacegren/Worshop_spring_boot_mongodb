package com.nicaciopereira.workshopmongo.dto;

import com.nicaciopereira.workshopmongo.domain.User;

import java.io.Serializable;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1l;

    private Integer id;
    private String name;
    private String email;

    public UserDTO(){

    }
    public UserDTO(User obj){
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
