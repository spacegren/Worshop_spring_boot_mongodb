package com.nicaciopereira.workshopmongo.services;

import com.nicaciopereira.workshopmongo.domain.User;
import com.nicaciopereira.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    public UserRepository repo;

    //vai no banco de dados e retorna todos user
    public List<User> findAll(){
        return repo.findAll();
    }
}
