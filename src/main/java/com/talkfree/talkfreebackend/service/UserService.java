package com.talkfree.talkfreebackend.service;

import com.talkfree.talkfreebackend.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User getUser(String userId);
    List<User> getUserList();

    int addUser(User user);
    int addUsers();

    int updateUser();

    int deleteUer();
    int deleteUserList();
}
