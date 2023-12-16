package com.nicaciopereira.workshopmongo.repositories;

import com.jayway.jsonpath.internal.function.numeric.Min;
import com.nicaciopereira.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Text;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepositories extends MongoRepository<Post , String> {

    @Query("{'title': { $regex: ?0 , $options: 'i' } }")
    List<Post> searchTiles(String text);

    List<Post> findByTitleContainingIgnoreCase(String text);

    @Query("{ $and: [ { date: { $gte: ?1}} ,{ date: { $lte: ?2}}, { $or: [ {'title': { $regex: ?0 , $options: 'i' }}, {'body': { $regex: ?0 , $options: 'i' }},{'coments.text': { $regex: ?0 , $options: 'i' }} ]} ]}")
    List<Post> funSearch(String text , Date minDate , Date maxDate);


}
