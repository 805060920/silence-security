package com.silence.app.security.controller;

import com.silence.app.security.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class UserController {

    @GetMapping("/get/{userId}")
    public User getUser(){
        return new User("小明","1234");
    }

}
