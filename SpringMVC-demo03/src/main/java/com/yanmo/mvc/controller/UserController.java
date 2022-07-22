package com.yanmo.mvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {


    /**
     * 使用RESTFul风格模拟用户资源的增删改查
     *
     * /user        GET         查询所有用户信息
     * /user/1      GET         根据id查询用户信息
     * /user        POST        添加用户信息
     * /user/1      DELETE      根据id删除用户信息
     * /user        PUT         修改用户信息
     */

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getAllUser(){
        System.out.println("userList");
        return "success";
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String getUserById(){
        System.out.println("user");
        return "success";
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String addUser(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ){
        System.out.println(username);
        System.out.println(password);
        return "success";
    }

}
