package com.silence.app.security.controller;

import com.silence.app.security.entity.UserEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/orders")
public class UserController {

    @GetMapping("/{UserEntityId}")
    public UserEntity getUserEntity(){
        return new UserEntity("小明","1234");
    }


    @PostMapping
    public void add(Collection<UserEntity> UserEntitys){

    }


    @PutMapping("{UserEntityId}")
    public void update(){

    }

    @PutMapping
    public void updateBatch(Collection<UserEntity> UserEntitys){

    }


}
