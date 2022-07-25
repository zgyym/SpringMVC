package com.yanmo.restful.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class ScopeController {

    @RequestMapping("/testRequestByServletAPI")
    public String testRequestByServletAPI(HttpServletRequest request){
        request.setAttribute("testRequestScope","Hello,ServletAPI");
        return "success";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        //处理模型数据（model），即向request域中添加数据
        modelAndView.addObject("testRequestScope","Hello,ModelAndView");
        //设置视图名称
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/testModel")
    public String testModel(Model model){
        model.addAttribute("testRequestScope","Hello,model");
        System.out.println(model.getClass().getName());
        return "success";
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String,Object> map){
        map.put("testRequestScope","Hello,Map");
        System.out.println(map.getClass().getName());
        return "success";
    }

    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("testRequestScope","Hello,ModelMap");
        System.out.println(modelMap.getClass().getName());
        System.out.println(modelMap);
        return "success";
    }


    @RequestMapping("/testSession")
    public String testSession(HttpSession session){
        session.setAttribute("testRequestScope","Hello,Session");
        return "success";
    }

    @RequestMapping("/testApplication")
    public String testAApplication(HttpSession session){
        ServletContext application = session.getServletContext();
        application.setAttribute("testRequestScope","Hello,Application/ServletContext");
        return "success";
    }

    @RequestMapping("/testView")
    public String testView(){
        return "test_view";
    }

}
