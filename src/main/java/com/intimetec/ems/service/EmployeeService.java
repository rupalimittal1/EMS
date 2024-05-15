package com.intimetec.ems.service;

import com.intimetec.ems.entity.Employee;
import com.intimetec.ems.exception.NotFoundException;
import com.intimetec.ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            employee.setId(id);
            return employeeRepository.save(employee);
        } else {
            throw new NotFoundException("Employee not found with id: " + id);
        }
    }

    public void deleteEmployee(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            employeeRepository.deleteById(id);
        } else {
            throw new NotFoundException("Employee not found with id: " + id);
        }
    }
}

