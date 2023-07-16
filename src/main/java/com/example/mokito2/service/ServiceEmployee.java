package com.example.mokito2.service;

import com.example.mokito2.model.Employee;

public interface ServiceEmployee {

    void addEmployee(Employee employee);

    Employee removeEmployee(String name, String lastName);

    Employee findEmployee(String name, String lastName);

}

