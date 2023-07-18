package com.example.mokito2;

import com.example.mokito2.model.Employee;
import com.example.mokito2.service.DepartmentService;
import com.example.mokito2.service.DepartmentServiceImpl;
import com.example.mokito2.service.ServiceEmployee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

public class DepartmentServiceTest {
    private DepartmentService departmentService;

    @BeforeEach
    public void test1() {
        ServiceEmployee serviceEmployee = Mockito.mock(ServiceEmployee.class);
        when(departmentService.getAll()).thenReturn(listEmployee());


        departmentService = new DepartmentServiceImpl((DepartmentServiceImpl) serviceEmployee);
    }

    private List<Employee> listEmployee() {
        return List.of(new Employee(4, 10000, 1, "nick", "tres"));
    }

    @Test
    public void returnMaxSalaryDepartment4() {
        Optional<Employee> employee= departmentService.findDepartmentMaxSalaryEmployee(4, 1);
        Assertions.assertThat("mimi");
        Assertions.assertThat("si");
        Assertions.assertThat(21000);
        Assertions.assertThat(3);
    }

}
