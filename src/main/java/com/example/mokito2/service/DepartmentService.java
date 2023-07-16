package com.example.mokito2.service;

import com.example.mokito2.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface DepartmentService {

    Optional<Employee> findDepartmentMaxSalaryEmployee(Integer department, Integer id);

    Optional<Employee> findDepartmentMinSalaryEmployee(Integer department, Integer id);


    //  Optional<Employee> findAllSumSalaryDepartment(Integer department, Integer salary);

    Optional<List<Employee>> findDepartmentsAllEmployee(Integer id, Integer department);

    Collection<Employee> getAll();

    Map<Integer, List<Employee>> getAllDepartments();


}
