package com.talkfree.talkfreebackend.controller;

import com.talkfree.talkfreebackend.entity.User;
import com.talkfree.talkfreebackend.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@RestController
@Validated
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userServiceImpl;

    @GetMapping
    public User getUser(@RequestParam String userId){
        return userServiceImpl.getUser(userId);
    }

    @PostMapping
    public String addUser(@RequestBody User user){
        userServiceImpl.addUser(user);
        return "Success";
    }

//    @GetMapping
//    public User getUserList(@RequestParam String userName, HttpServletRequest request) {
//        request.getSession().
//    }

}
