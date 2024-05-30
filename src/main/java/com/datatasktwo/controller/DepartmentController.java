package com.datatasktwo.controller;

import com.datatasktwo.model.entity.Department;
import com.datatasktwo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<Department> getAllDepartments() {
        return employeeService.findAllDepartments();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable long id) {
        return employeeService.findDepartmentById(id);
    }

    @PostMapping
    public Department addDepartment(@RequestBody Department department) {
        return employeeService.saveDepartment(department);
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable long id, @RequestBody Department department) {
        department.setId(id);
        return employeeService.saveDepartment(department);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable long id) {
        employeeService.deleteDepartmentById(id);
    }
}
