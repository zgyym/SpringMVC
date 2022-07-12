package com.yanmo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {


    //根据请求地址的url“/” 跳转到 /WEB-INF/templates/index.html
    @RequestMapping(value = "/")
    public String index(){
        //返回视图名称
        return "index";
    }

    @RequestMapping("/target")
    public String toTarget(){
        return "target";
    }

    //以上两个@RequestMapping里的value值不能相等，程序不知道返回index还是target
}
