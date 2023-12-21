package com.jrp.projectmanager.controllers;

import com.jrp.projectmanager.dao.EmployeeRepository;
import com.jrp.projectmanager.entity.Employee;
import com.jrp.projectmanager.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeService empService;
    @GetMapping("")
    public String displayEmployee(Model model){
        List<Employee> employeeList = empService.getAll();
        model.addAttribute("employees", employeeList);
        return "employees/main";
    }
    @GetMapping("/new")
    public String displayEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employees/new-employee";
    }
    @PostMapping("/save")
    public String createEmployee(Employee employee, Model model){
        empService.save(employee);
        return "redirect:/employees";
    }
}
