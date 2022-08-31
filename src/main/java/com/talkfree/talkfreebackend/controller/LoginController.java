package com.talkfree.talkfreebackend.controller;

import com.talkfree.talkfreebackend.entity.Result;
import com.talkfree.talkfreebackend.entity.User;
import com.talkfree.talkfreebackend.service.UserService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.util.HashMap;

@RestController
@RequestMapping("/user_service")
@CrossOrigin
public class LoginController {


    @Resource
    private UserService userServiceImpl;

    @Resource
    RedisTemplate<String, String> template;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody HashMap<String, String> form, HttpServletResponse response) {

        System.out.println(form);
        if(!validate(form)) return new ResponseEntity<Result>(new Result("Bad format",-1), HttpStatus.BAD_REQUEST);
        
        String email = form.get("email");
        String password = form.get("password");

        User user = userServiceImpl.getUserByEmail(email);
        if(user == null) return new ResponseEntity<Result>(new Result("User doesn't exist", -1), HttpStatus.OK);
        else {
            if(password.equals(user.getPassword())) {
                Cookie cookie = new Cookie("user-token", user.getId());
                cookie.setPath("/");
                cookie.setMaxAge(3600);
                response.addCookie(cookie);
                template.opsForSet().add("user-token", user.getId());
                template.expire("sessionId", Duration.ofSeconds(60));
                return new ResponseEntity<Result>(new Result("Login successfully",0), HttpStatus.OK);
            }
            else return new ResponseEntity<Result>(new Result("Please check your password", -1), HttpStatus.OK);
        }
    }


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody HashMap<String, String> form) {

        if(!validate(form)) return new ResponseEntity<String>("Bad format", HttpStatus.BAD_REQUEST);

        String email = form.get("email");
        String password = form.get("password");

        if(userServiceImpl.getUserByEmail(email) != null) {
            return new ResponseEntity<String>("The Email has been registered", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(form.containsKey("name")?form.get("name"):"");
        user.setAddress(form.containsKey("address")?form.get("address"):"");
        user.setTelephone(form.containsKey("telephone")?form.get("telephone"):"");

        userServiceImpl.addUser(user);
        return new ResponseEntity<String>("Register successfully", HttpStatus.OK);
    }



    public boolean validate(HashMap<String, String> form) {
        if(!form.containsKey("email") || !form.containsKey("password")) return false;

        String email = form.get("email");
        String password = form.get("password");
        if(email.length() == 0) return false;
        if(password.length() == 0) return false;

        else return true;
    }
}
