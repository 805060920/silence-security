package com.silence.app.security.controller;

import com.silence.app.security.entity.UserEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "api/v1/students")
public class UserController {

    @GetMapping(path = "{studentId}")
    public String getUserEntity(@PathVariable("studentId") Integer studentId){
        return "第" + studentId + "名学生";
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
