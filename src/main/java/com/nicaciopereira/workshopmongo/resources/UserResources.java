package com.nicaciopereira.workshopmongo.resources;

import com.nicaciopereira.workshopmongo.domain.User;
import com.nicaciopereira.workshopmongo.dto.UserDto;
import com.nicaciopereira.workshopmongo.services.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResources {
    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDto>> findyAll() {
        List<User> list = service.findAll();
        List<UserDto> listDto = list.stream().map(x -> new UserDto(x)).collect(Collectors.toList());
        System.out.println("RETORNANDO USERS " + list);
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDto> findyById(@PathVariable String id) {
        User obj = service.findById(id);
        return ResponseEntity.ok().body(new UserDto(obj));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody UserDto objDto) {
        User obj = service.fromDto(objDto);
        obj = service.insert(obj);
        //pegando endereço do novo objeto que inseri
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        //retorna resposta vazia com codigo 201 e cabeçario contendo a localizaçao do novo recurso criado
        return ResponseEntity.created(uri).build();
    }

}