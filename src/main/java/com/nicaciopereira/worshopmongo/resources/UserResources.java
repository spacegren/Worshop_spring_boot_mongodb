package com.nicaciopereira.worshopmongo.resources;

import com.nicaciopereira.worshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

    @RequestMapping(method = RequestMethod.GET) //tanto faz
    @GetMapping // tantofaz
    public ResponseEntity<List<User>> findAll() {
        User nicacio = new User(null, "nicacio@gmail.com", "nicacio");
        User maria = new User(null, "maria@gmail.com", "maria");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(nicacio, maria));
        return ResponseEntity.ok().body(list);
    }
}