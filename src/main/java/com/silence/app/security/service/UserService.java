package com.silence.app.security.service;

import com.silence.app.security.entity.UserEntity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService{

    private static final List<UserEntity> users = Arrays.asList(
            new UserEntity("小明", "123456")
            ,new UserEntity("小黄", "123456")
            ,new UserEntity("小兰", "123456"));





    public UserEntity findUserByName(String username) throws UsernameNotFoundException {
        return users.stream().filter(entity -> username.equals(entity.getUsername())).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("用户不存在"));
    }


    public String findUserPermissions(String username){
        return "user:view,user:update,user:delete,order:view";
    }
}
