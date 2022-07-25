package com.yanmo.restful.controller;


import com.yanmo.restful.bean.Employee;
import com.yanmo.restful.dao.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String getALLEmployee(Model model){
        Collection<Employee> emoloyeeList = employeeDAO.getAll();
        model.addAttribute("emoloyeeList",emoloyeeList);
        return "employee_list";
    }

    @RequestMapping(value = "/employee/{id}",method = RequestMethod.DELETE)
    public String delById(@PathVariable("id") Integer id){
        employeeDAO.delete(id);
        //页面跳转必须通过转发或者重定向来进行跳转
        //跳转到列表页面，但是列表页面的数据是由getALLEmployee()方法来完成的，所以需要重定向或者转发
        return "redirect:/employee";
    }

    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public String add(Employee employee){
        employeeDAO.save(employee);
        return "redirect:/employee";
    }

    @RequestMapping(value = "employee/{id}",method = RequestMethod.GET)
    public String getEmployeeById(@PathVariable Integer id,Model model){
        Employee employee = employeeDAO.get(id);
        model.addAttribute("employee",employee);
        return "employee_update";
    }

    @RequestMapping(value = "/employee",method = RequestMethod.PUT)
    public String update(Employee employee){
        employeeDAO.save(employee);
        return "redirect:employee";
    }
}
