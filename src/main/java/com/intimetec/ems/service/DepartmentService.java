package com.intimetec.ems.service;

import com.intimetec.ems.entity.Department;
import com.intimetec.ems.exception.NotFoundException;
import com.intimetec.ems.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(Long id, Department department) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if (optionalDepartment.isPresent()) {
            department.setId(id);
            return departmentRepository.save(department);
        } else {
            throw new NotFoundException("Department not found with id: " + id);
        }
    }

    public void deleteDepartment(Long id) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if (optionalDepartment.isPresent()) {
            departmentRepository.deleteById(id);
        } else {
            throw new NotFoundException("Department not found with id: " + id);
        }
    }
}

