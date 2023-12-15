package com.nicaciopereira.workshopmongo.repositories;

import com.nicaciopereira.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepositories extends MongoRepository<Post , String> {

    @Query("{'title': { $regex: ?0 , $options: 'i' } }")
    List<Post> searchTiles(String text);

    List<Post> findByTitleContainingIgnoreCase(String text);

}
