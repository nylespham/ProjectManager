package com.jrp.projectmanager.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jrp.projectmanager.dao.EmployeeRepository;
import com.jrp.projectmanager.dao.ProjectRepository;
import com.jrp.projectmanager.dto.ChartData;
import com.jrp.projectmanager.dto.EmployeeProject;
import com.jrp.projectmanager.entity.Employee;
import com.jrp.projectmanager.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class HomeController {
    @Autowired
    ProjectRepository proRep;
    @Autowired
    EmployeeRepository empRep;
    @GetMapping("/")
    public String displayHomePage(Model model) throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();

        List<Project> projects = proRep.findAll();
        List<EmployeeProject> employeesProjectCount = empRep.employeeProject();
//        List <ChartData> projectData = proRep.getProjectStatus();

        model.addAttribute("projects", projects);
        model.addAttribute("employees", employeesProjectCount);
        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonString = objectMapper.writeValueAsString(projectData);

//        model.addAttribute("projectStatus", jsonString);

        return "main/home";
    };
}
