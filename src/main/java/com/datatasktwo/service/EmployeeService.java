package com.datatasktwo.service;

import com.datatasktwo.exception.DepartmentNotFoundException;
import com.datatasktwo.exception.EmployeeNotFoundException;
import com.datatasktwo.model.entity.Department;
import com.datatasktwo.model.entity.Employee;
import com.datatasktwo.projection.EmployeeProjection;
import com.datatasktwo.repository.DepartmentRepository;
import com.datatasktwo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(()-> new EmployeeNotFoundException("Employee with id " + id + " not found"));
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<EmployeeProjection> findAllEmployeeProjections() {
        return employeeRepository.findAllEmployeeProjections();
    }

    public List<Department> findAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department findDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(()-> new DepartmentNotFoundException("Department with id " + id + " not found"));
    }

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }
}
