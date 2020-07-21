package com.silence.app.security.service;

import com.silence.app.security.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Component
public class SilenceUserdetailService implements UserDetailsService {


    @Resource
    private UserService userService;


    //将用户的拥有的角色权限放入


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity entity = userService.findUserByName(s);
        if (entity != null) {
            // 查询用户角色、权限信息
            String permissions = userService.findUserPermissions(s);
            List<GrantedAuthority> grantedAuthorityList = AuthorityUtils.NO_AUTHORITIES;
            if (!StringUtils.isEmpty(permissions)){
                grantedAuthorityList = AuthorityUtils.commaSeparatedStringToAuthorityList(permissions);
            }
            return new User(s, entity.getPassword(), grantedAuthorityList);
        }else {
            throw new UsernameNotFoundException("用户不存在");
        }
    }
}
