package com.nicaciopereira.workshopmongo.services;

import com.nicaciopereira.workshopmongo.domain.Post;
import com.nicaciopereira.workshopmongo.domain.User;
import com.nicaciopereira.workshopmongo.dto.UserDto;
import com.nicaciopereira.workshopmongo.repositories.PostRepositories;
import com.nicaciopereira.workshopmongo.repositories.UserRepository;
import com.nicaciopereira.workshopmongo.services.exeption.ObjectNotFoundExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    public PostRepositories repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundExeption("OBJETO NAO ENCONTRADO"));
    }

    public List<Post> findAll() {
        return repo.findAll();
    }

    public List<Post> findByTitle(String text) {
        return repo.searchTiles(text);

    }

    public List<Post> fullSearch(String text , Date mindate , Date maxDate){
        maxDate = new Date(maxDate.getTime() + 24*60*60*1000);
        return repo.funSearch(text, mindate, maxDate);
    }

}
