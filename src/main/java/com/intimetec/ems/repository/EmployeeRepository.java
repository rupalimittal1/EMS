package com.intimetec.ems.repository;

import com.intimetec.ems.entity.Department;
import com.intimetec.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Custom query to find employees by department
    List<Employee> findByDepartment(Department department);

    List<Employee> findByName(String name);

    // Custom query to find active employees
    @Query("SELECT e FROM Employee e WHERE e.activeStatus = true")
    List<Employee> findActiveEmployees();
}
