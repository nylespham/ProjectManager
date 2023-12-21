package com.jrp.projectmanager.controllers;

import com.jrp.projectmanager.dao.EmployeeRepository;
import com.jrp.projectmanager.dao.ProjectRepository;
import com.jrp.projectmanager.entity.Employee;
import com.jrp.projectmanager.entity.Project;
import com.jrp.projectmanager.services.EmployeeService;
import com.jrp.projectmanager.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;


@Controller
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    ProjectService proService;
    @Autowired
    EmployeeService empService;
    @GetMapping("")
    public String displayProject(Model model){
        List<Project> projectList = proService.getAll();
        model.addAttribute("projects", projectList);
        return "projects/main";
    }
    @GetMapping("/new")
    public String displayProjectForm(Model model){
        Project aProject = new Project();
        List<Employee> employeeList = empService.getAll();
        model.addAttribute("project", aProject);
        model.addAttribute("allEmployees", employeeList);
        return "projects/new-project";
    }
    @PostMapping(value = "/save")
    public String createProject(Project project, Model model){
        proService.save(project);
        return "redirect:/projects";
    }
}
