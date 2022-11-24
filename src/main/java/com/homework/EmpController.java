package com.homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
public class EmpController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/viewemp")
    public String viewemp (Model m) throws ClassNotFoundException {
        List<Employee> list=employeeService.getAllEmplFromService();
        m.addAttribute("list",list);
        return "viewemp";
    }


    @RequestMapping(value = "/editemp/{id}")
    public String edit(@PathVariable int id, Model m){
        Employee emp=employeeService.getEmployeeById(id);
        m.addAttribute("command",emp);
        return "empeditform";
    }





}
