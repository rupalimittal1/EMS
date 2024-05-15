package com.intimetec.ems.repository;

import com.intimetec.ems.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    // Custom query to find departments by name
    List<Department> findByName(String name);

    // Custom query to find active departments
    @Query("SELECT d FROM Department d WHERE d.activeStatus = true")
    List<Department> findActiveDepartments();
}


