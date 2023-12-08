package com.nicaciopereira.workshopmongo.resources;

import com.nicaciopereira.workshopmongo.domain.User;
import com.nicaciopereira.workshopmongo.dto.UserDTO;
import com.nicaciopereira.workshopmongo.services.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResources {
    @Autowired
    private UserService service;
    @GetMapping
    public ResponseEntity<List<UserDTO>>findyAll() {
        List<User> list = service.findAll();
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        System.out.println("RETORNANDO USERS " + list);
        return ResponseEntity.ok().body(listDto);
    }
    @RequestMapping(value="/{id}" , method = RequestMethod.GET)
    public ResponseEntity<UserDTO>findyById(@PathVariable String id) {
        User obj = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }
}