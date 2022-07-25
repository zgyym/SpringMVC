package com.yanmo.restful.controller;


import com.yanmo.restful.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Controller
public class ParamController {

    @RequestMapping("/param")
    public String param(){
        return "test_param";
    }


    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request) {
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        System.out.println(username);
        System.out.println(pwd);
        return "success";
    }

    @RequestMapping("/testParam")
    public String testParam(
            @RequestParam("username") String username,
            @RequestParam(value = "password",defaultValue = "123123")String password,
            @RequestParam(value = "hobby",required = false)String[] hobby,
            @RequestHeader("host") String  host) {

        System.out.println(username);
        System.out.println(password);
        String s = Arrays.toString(hobby);
        System.out.println(s);
        System.out.println(host);

        return "success";
    }

    @RequestMapping("/testBean")
    public String testBean(User user){
        System.out.println(user);
        return "success";
    }
}
