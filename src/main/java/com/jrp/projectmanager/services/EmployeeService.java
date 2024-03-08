package com.jrp.projectmanager.services;

import com.jrp.projectmanager.dao.EmployeeRepository;
import com.jrp.projectmanager.dto.EmployeeProject;
import com.jrp.projectmanager.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository empRepo;

    public Employee save(Employee employee) {
        return empRepo.save(employee);
    }

    public Iterable<Employee> getAll(){
        return empRepo.findAll();
    }

    public List<EmployeeProject> employeeProject(){
        return empRepo.employeeProject();
    }
}
