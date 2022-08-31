package com.talkfree.talkfreebackend.repository;

import com.talkfree.talkfreebackend.entity.User;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    @Query("{id: '?0'}")
    User findUserById(String Id);

    @Query("{email: '?0'}")
    User findUserByEmail(String email);

    @Query("{name:'?0'}")
    List<User> findUserByName(String name);

    @DeleteQuery (value = "{id: '?0'}")
    User deleteUserById(String Id);

    @Override
    long count();
}
