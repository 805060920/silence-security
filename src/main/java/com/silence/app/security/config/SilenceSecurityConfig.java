package com.silence.app.security.config;


import com.silence.app.security.service.SilenceUserDetailService;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证服务器搭建
 */
@EnableWebSecurity
public class SilenceSecurityConfig extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .requestMatchers()
                .antMatchers("/oauth/**", "/login")
                .and()
                .authorizeRequests()
                .antMatchers("/oauth/**").authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .successHandler(new SilenceAuthenticationSuccessHandler())
                .failureHandler(new SilenceAuthenticationFailureHandler())
                .permitAll()
                .and().httpBasic().disable();
    }


    //TODO 身份验证配置
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new SilenceUserDetailService());
    }


    public static class SilenceAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

        @Override
        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        }
    }


    public static class SilenceAuthenticationFailureHandler implements AuthenticationFailureHandler {

        @Override
        public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {


        }
    }



}
