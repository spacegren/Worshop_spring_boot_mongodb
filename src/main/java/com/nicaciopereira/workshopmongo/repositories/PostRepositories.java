package com.nicaciopereira.workshopmongo.repositories;

import com.nicaciopereira.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepositories extends MongoRepository<Post , String> {


}
