package com.talkfree.talkfreebackend.service.impl;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.talkfree.talkfreebackend.constant.Constant;
import com.talkfree.talkfreebackend.entity.LoginTicket;
import com.talkfree.talkfreebackend.entity.User;
import com.talkfree.talkfreebackend.repository.LoginTicketRepository;
import com.talkfree.talkfreebackend.repository.UserRepository;
import com.talkfree.talkfreebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.Duration;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private RedisOperations<String, String> operations;

    @Resource
    RedisTemplate<String, String> template;

    @Override
    public User getUserById(String userId) {

        User user = userRepository.findUserById(userId);
        return user;
    }

    @Override
    public User getUserByEmail(String email) {
        User user = userRepository.findUserByEmail(email);
        return user;
    }

    @Override
    public List<User> getUserByName(String userName) {
        List<User> userList = userRepository.findUserByName(userName);
        return userList;
    }

    @Override
    public List<User> getUserList() {
        List<User> userList = userRepository.findAll();
        System.out.println("The number of the user is "+userList.size());
        return userList;
    }

    @Override
    public int addUser(User user) {
        userRepository.save(user);
        template.opsForSet().add("sessionId", "1234567");
        template.expire("sessionId", Duration.ofSeconds(60));
        return 1;
    }

    @Override
    public int addUsers() {
        return 0;
    }

    @Override
    public int updateUser() {
        return 0;
    }

    @Override
    public User deleteUser(String Id) {
        return userRepository.deleteUserById(Id);
    }

    @Override
    public int deleteUserList() {

        try{
            userRepository.deleteAll();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
