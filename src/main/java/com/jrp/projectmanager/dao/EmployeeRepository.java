package com.jrp.projectmanager.dao;

import com.jrp.projectmanager.dto.EmployeeProject;
import com.jrp.projectmanager.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
@Query(nativeQuery = true, value="SELECT employee.first_name as firstName , employee.last_name as lastName, COUNT(project_employee.employee_id) as projectcount\n" +
        "FROM employee\n" +
        "LEFT JOIN project_employee\n" +
        "ON project_employee.employee_id = employee.employee_id\n" +
        "GROUP BY employee.first_name, employee.last_name\n" +
        "ORDER BY employee.first_name DESC;")
    public List<EmployeeProject> employeeProject();
}
