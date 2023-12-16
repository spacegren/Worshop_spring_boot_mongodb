package com.nicaciopereira.workshopmongo.resources;

import com.nicaciopereira.workshopmongo.domain.Post;
import com.nicaciopereira.workshopmongo.resources.util.URL;
import com.nicaciopereira.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResources {

    @Autowired
    private PostService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findyById(@PathVariable String id) {
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findyByTitle(@RequestParam(value = "text" , defaultValue = "")String text) {
        text = URL.decoderParam(text);
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/fullsearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value = "text" , defaultValue = " ") String text ,
            @RequestParam(value = "minDate" , defaultValue = " ") String minDate ,
            @RequestParam(value = "maxDate" , defaultValue = " ") String maxDate) {
        text = URL.decoderParam(text);
        Date min = URL.convertDate(minDate , new Date(0L));
        Date max = URL.convertDate(maxDate , new Date());
        List<Post> list = service.fullSearch(text ,min,max);
        return ResponseEntity.ok().body(list);

    }
}
