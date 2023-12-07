package com.nicaciopereira.workshopmongo.resources;

import com.nicaciopereira.workshopmongo.domain.User;
import com.nicaciopereira.workshopmongo.dto.UserDTO;
import com.nicaciopereira.workshopmongo.services.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResources {
    @Autowired
    private UserService service;
    @GetMapping
    public ResponseEntity<List<User>>findyAll() {
        List<User> list = service.findAll();
        System.out.println("RETORNANDO USERS " + list);
        return ResponseEntity.ok().body(list);
    }
}