package com.example.mokito2.service;

import com.example.mokito2.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentServiceImpl departmentService;

    public DepartmentServiceImpl(DepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
    }

    private Map<Integer, Employee> storage = new HashMap<>();

    @Override
    public Collection<Employee> getAll() {
        return storage.values();
    }

    @Override
    public Optional<Employee> findDepartmentMinSalaryEmployee(Integer department, Integer id) {
        return Optional.ofNullable(departmentService.getAll()
                .stream()
                .filter(employee -> Objects.equals(employee.getDepartment(), department))
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new IllegalArgumentException("don't have employee")));
    }

    @Override
     public Integer findAllSumSalaryDepartment(Integer department) {
       return departmentService.getAll()
              .stream()
              .filter(employee -> Objects.equals(employee.getDepartment(), department))
               .mapToInt(Employee::getSalary)
               .sum();
    }

    @Override
    public Optional<List<Employee>> findDepartmentsAllEmployee(Integer id, Integer department) {
        return Optional.of(departmentService.getAll()
                .stream()
                .filter(employee -> Objects.equals(employee.getDepartment(), department))
                .collect(Collectors.toList()));
    }

    @Override
    public Map<Integer, List<Employee>> getAllDepartments() {
        return departmentService.getAll()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    @Override
    public Optional<Employee> findDepartmentMaxSalaryEmployee(Integer department, Integer id) {
        return Optional.ofNullable(departmentService.getAll()
                .stream()
                .filter(employee -> Objects.equals(employee.getDepartment(), department))
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new IllegalArgumentException("don't have employee")));
    }
}
