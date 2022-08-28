package com.talkfree.talkfreebackend.repository;

import com.talkfree.talkfreebackend.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<User, String> {

    @Query("{id: '?0'}")
    User findUserById(String Id);

    @Query("{name:'?0'}")
    User findUserByName(String name);


    @Override
    long count();
}
