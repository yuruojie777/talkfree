package com.talkfree.talkfreebackend.controller;

import com.talkfree.talkfreebackend.entity.LoginTicket;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@RestController
@RequestMapping("/login")
public class LoginController {


    @PostMapping
    public Object login(@RequestBody HashMap<String, String> form, HttpServletResponse response) {
        if(!form.containsKey("username") || !form.containsKey("password")) return new Error("Bad request format");

        String username = form.get("username");
        String password = form.get("password");

        if(username.equals("Ruojie") && password.equals("1234567")) {
            response.addCookie(new Cookie("sessionId", "1234567"));
            return "Login successfully!";
        }
        else return "Please check username or password";
    }
}
