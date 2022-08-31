package com.talkfree.talkfreebackend.controller;

import com.talkfree.talkfreebackend.entity.User;
import com.talkfree.talkfreebackend.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@Validated
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Resource
    private UserService userServiceImpl;

    @GetMapping
    public User getUser(@RequestParam String userId){
        return userServiceImpl.getUserById(userId);
    }

    @GetMapping("/all")
    public List<User> getUserList() {
        return userServiceImpl.getUserList();
    }

    @PostMapping
    public String addUser(@RequestBody User user){
        userServiceImpl.addUser(user);
        return "Success";
    }

    @DeleteMapping
    public String deleteUser(@RequestParam String userId) {
        System.out.println("Deleting userId: " + userId + "...");
        if(userServiceImpl.deleteUser(userId) != null) return "Success";
        else return "Failed";
    }

    @DeleteMapping("/all")
    public String deleteAllUser() {
        if(userServiceImpl.deleteUserList() > 0) return "Success";
        else return "Failed";
    }

}
