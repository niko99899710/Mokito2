package com.example.mokito2.service;

import com.example.mokito2.exception.EmployeeAllredyAddException;
import com.example.mokito2.exception.EmployeeNotFindException;
import com.example.mokito2.model.Employee;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ServiceEmployeeImpl implements ServiceEmployee {
    private Map<String, Employee> storage = new HashMap<>();

    @Override
    public void addEmployee(Employee employee) {
        if (storage.containsKey(employee.getName() + employee.getSurName() + employee.getSalary() + employee.getDepartment())) {
            throw new EmployeeAllredyAddException("Такой сотрудник уже есть");
        }
        storage.put(employee.getName() + employee.getSurName() + employee.getSalary() + employee.getDepartment(), employee);
    }

    @Override
    public Employee removeEmployee(String name, String surName) {
        if (!storage.containsKey(name + surName)) {
            throw new EmployeeNotFindException("Сотрудник не найден");
        }
        storage.remove(name + surName);
        return null;
    }

    @Override
    public Employee findEmployee(String name, String surName) {
        if (!storage.containsKey(name + surName)) {
            throw new EmployeeNotFindException("Сотрудник не найден");
        }
        return storage.get(name + surName);
    }
}
