package com.example.mokito2.controller;

import com.example.mokito2.model.Employee;
import com.example.mokito2.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping("/{id}/salary/max")
    @ResponseBody
    public Optional<Employee> findDepartmentMaxSalaryEmployee
            (@PathVariable Integer department, @PathVariable Integer id){
        return departmentService.findDepartmentMaxSalaryEmployee(department,id);
    }

    @GetMapping( "/{id}/salary/min")
    @ResponseBody
    public Optional<Employee> findDepartmentMinSalaryEmployee
            (@PathVariable Integer department, @PathVariable Integer id){
        return departmentService.findDepartmentMinSalaryEmployee(department, id);
    }

    //  @GetMapping("{id}/salary/sum")
    //  public double findAllSumSalaryDepartment (@PathVariable Integer department,
    //                                          @PathVariable Integer salary) {
    //return departmentServicee.findAllSumSalaryDepartment(department,salary);
    // }

    @GetMapping(value = "/{id}", params = "/employees")
    public Optional<List<Employee>> findDepartmentsAllEmployee (@PathVariable Integer id ,
                                                                @PathVariable Integer department){
        return departmentService.findDepartmentsAllEmployee(id, department);
    }

    @GetMapping("/employees")
    public Map<Integer, List <Employee>> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

}
