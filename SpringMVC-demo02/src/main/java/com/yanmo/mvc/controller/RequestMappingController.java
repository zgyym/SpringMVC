package com.yanmo.mvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
/*@RequestMapping("/hello")*/
public class RequestMappingController {

    @RequestMapping(value = {"/testRequestMapping", "/test"},
            method = {RequestMethod.POST, RequestMethod.GET})
    public String success() {
        return "success";
    }


    @GetMapping("/testGetMapping")
    public String testGetMapping(){
        return "success";
    }
    @RequestMapping(
            value = "/testParamsAndHeaders",
            params = {"username","password"},
            headers = {"Host=localhost:8080"}
    )
    public String testParamsAndHeaders(){
        return "success";
    }

    //@RequestMapping("/a?a/testAnt")
    //@RequestMapping("/a*a/testAnt")
    @RequestMapping("/**/testAnt")
    public String testAnt(){
        return "success";
    }

    @RequestMapping("/testPath/{id}/{username}")
    public String testPath(@PathVariable("id")Integer id,@PathVariable("username")String username){
        System.out.println("id：" + id + "\nusername：" + username);
        return "success";
    }

}
