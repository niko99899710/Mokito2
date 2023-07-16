package com.example.mokito2.controller;

import com.example.mokito2.model.Employee;
import com.example.mokito2.service.ServiceEmployee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
    @RestController
    @RequestMapping("/department")
    public class EmployeeController {
        private final ServiceEmployee serviceEmployee;

        public EmployeeController(ServiceEmployee serviceEmployee) {
            this.serviceEmployee = serviceEmployee;
        }

        @GetMapping("/add")
        public void addEmployee(@RequestParam Integer department,
                                @RequestParam Integer salary,
                                @RequestParam Integer id,
                                @RequestParam String name,
                                @RequestParam String surName) {
            serviceEmployee.addEmployee(new Employee(department, salary, id, name, surName));
        }

        @GetMapping("/remove")
        public void removeEmployee(@RequestParam String name, @RequestParam String surName) {
            serviceEmployee.removeEmployee(name, surName);
        }

        @GetMapping("find")
        public void findEmployee(@RequestParam String name, @RequestParam String surName) {
            serviceEmployee.findEmployee(name, surName);
        }

    }

