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
    public User getUser(String userId) {

        User user = userRepository.findUserByName(userId);
        return user;
    }

    @Override
    public List<User> getUserList() {
        return null;
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
    public int deleteUer() {
        return 0;
    }

    @Override
    public int deleteUserList() {
        return 0;
    }
}
