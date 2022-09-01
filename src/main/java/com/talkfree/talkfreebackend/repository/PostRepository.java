package com.talkfree.talkfreebackend.repository;

import com.talkfree.talkfreebackend.entity.Post;
import com.talkfree.talkfreebackend.entity.User;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {
    @Query("{id: '?0'}")
    Post findPostById(String Id);

    @Query("{email: '?0'}")
    List<Post> findPostsByUserEmail(String email);

    @DeleteQuery(value = "{id: '?0'}")
    Post deletePostById(String Id);

    @Override
    long count();
}
