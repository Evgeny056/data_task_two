package com.datatasktwo.repository;

import com.datatasktwo.model.entity.Employee;
import com.datatasktwo.projection.EmployeeProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT " +
            "e.firstName || ' ' || e.lastName as fullName, " +
            "e.position as position, " +
            "d.name as departmentName " +
            "FROM Employee e " +
            "JOIN e.department d")
    List<EmployeeProjection> findAllEmployeeProjections();
}
