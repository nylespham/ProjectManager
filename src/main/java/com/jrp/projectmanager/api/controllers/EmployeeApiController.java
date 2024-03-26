package com.jrp.projectmanager.api.controllers;

import com.jrp.projectmanager.dao.EmployeeRepository;
import com.jrp.projectmanager.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/app-api/employees")
public class EmployeeApiController {
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping
    public Iterable<Employee> getEmployee(){
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id){
        return employeeRepository.findByEmployeeId(id);
    }
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }
    @PatchMapping(path="/{id}")
    public Employee partialUpdate(@PathVariable("id") Long id, @RequestBody Employee employee){
        Employee emp = employeeRepository.findByEmployeeId(id);
        if (employee.getEmail() != null) {
            emp.setEmail(employee.getEmail());
        }
        if (employee.getFirstName() != null) {
            emp.setFirstName(employee.getFirstName());
        }
        if (employee.getLastName() != null) {
            emp.setLastName(employee.getLastName());
        }
        return employeeRepository.save(emp);
    }
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id){
        try {
            employeeRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            System.out.println(e);
        }

    }
    @GetMapping(params = {"page", "size"})
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Employee> findPaginatedEmployee(@RequestParam("page") int page, @RequestParam("size") int size){
        Pageable pageAndSize = PageRequest.of(page, size);
        return employeeRepository.findAll(pageAndSize);
    }

}
