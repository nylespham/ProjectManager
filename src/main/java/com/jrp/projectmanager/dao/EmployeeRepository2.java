package com.jrp.projectmanager.dao;

import com.jrp.projectmanager.dto.EmployeeProject;
import com.jrp.projectmanager.entity.Employee;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@Repository
@Profile("prod")
public interface EmployeeRepository2 extends EmployeeRepository {
    @Override
    default List<Employee> findAll() {
        Employee employee = new Employee("Mike", "Dawson", "jayson.d@gmail.com");
        Employee employee1 = new Employee("Mike", "Dawson", "jayson.d@gmail.com");
        return Arrays.asList(employee, employee1);
    };

    @Override
    default List<EmployeeProject> employeeProject() {
        return null;
    }

    @Override
    default <S extends Employee> S save(S entity) {
        return null;
    }

    @Override
    default <S extends Employee> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    default Optional<Employee> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    default boolean existsById(Long aLong) {
        return false;
    }

    @Override
    default Iterable<Employee> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    default long count() {
        return 0;
    }

    @Override
    default void deleteById(Long aLong) {

    }

    @Override
    default void delete(Employee entity) {

    }

    @Override
    default void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    default void deleteAll(Iterable<? extends Employee> entities) {

    }

    @Override
    default void deleteAll() {

    }
}
