package com.example.mokito2;

import com.example.mokito2.exception.EmployeeAllredyAddException;
import com.example.mokito2.exception.EmployeeNotFindException;
import com.example.mokito2.model.Employee;
import com.example.mokito2.service.ServiceEmployee;
import com.example.mokito2.service.ServiceEmployeeImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ServiceEmployeeTest {
    private final ServiceEmployee serviceEmployee = new ServiceEmployeeImpl();

    @Test
    public void addEmployee(){
        Employee employee = new Employee(4, 10000, 1,"nick", "tres");
        serviceEmployee.addEmployee(employee);

        Employee newEmployee = serviceEmployee.findEmployee("nick","tres");
        Assertions.assertEquals(employee,newEmployee);
    }
    @Test
    public void  exceptionAllredyAddEmployee(){
        Employee employee = new Employee(4, 10000, 1,"nick", "tres");
        serviceEmployee.addEmployee(employee);
        Assertions.assertThrows(EmployeeAllredyAddException.class, () -> serviceEmployee.addEmployee(employee));
    }

    @Test
    public void removeEmployee(){
        Employee employee = new Employee(4, 10000, 1,"nick", "tres");
        serviceEmployee.addEmployee(employee);

        Employee newEmployee = serviceEmployee.removeEmployee("nick","tres");
        Assertions.assertEquals(employee,newEmployee);

    }

    @Test
    public void  exceptionNotFindEmployee(){
        Employee employee = new Employee(4, 10000, 1,"nick", "tres");
        serviceEmployee.addEmployee(employee);
        Assertions.assertThrows(EmployeeNotFindException.class, () -> serviceEmployee.addEmployee(employee));
    }


}