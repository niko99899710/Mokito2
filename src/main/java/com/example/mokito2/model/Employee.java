package com.example.mokito2.model;

import java.util.Objects;

public class Employee {
    private Integer department;
    private Integer salary;
    private Integer id;
    private String name;
    private String surName;

    public Employee(Integer department, Integer salary, Integer id, String name, String surName) {
        this.department = department;
        this.salary = salary;
        this.id = id;
        this.name = name;
        this.surName = surName;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(department, employee.department) && Objects.equals(salary, employee.salary) && Objects.equals(id, employee.id) && Objects.equals(name, employee.name) && Objects.equals(surName, employee.surName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(department, salary, id, name, surName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "department=" + department +
                ", salary=" + salary +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                '}';
    }
}

