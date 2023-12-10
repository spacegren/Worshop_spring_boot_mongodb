package com.nicaciopereira.workshopmongo.services;

import com.nicaciopereira.workshopmongo.domain.User;
import com.nicaciopereira.workshopmongo.dto.UserDto;
import com.nicaciopereira.workshopmongo.repositories.UserRepository;
import com.nicaciopereira.workshopmongo.services.exeption.ObjectNotFoundExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    public UserRepository repo;

    //vai no banco de dados e retorna todos user
    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(String id){
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() ->new ObjectNotFoundExeption("OBJETO NAO ENCONTRADO"));
    }

    public User insert(User obj){
        return repo.insert(obj);
    }

    public void delete(String id){
        repo.findById(id);
        repo.deleteById(id);
    }

    public User update(User obj){
        User newObj = repo.findById(obj.getId()).orElse(null);
        if (newObj == null){
            throw new ObjectNotFoundExeption("objeto nao encontardo");
        }
        updateDate(newObj , obj);
        return repo.save(newObj);
    }

    private void updateDate(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());

    }

    //dpendendo da situaçao , pra instancia o user posso querer acessar o banco de dados e quem ja tem isso é userservice
    //para manutençao fica mais simples
    public User fromDto(UserDto objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());

    }
}
