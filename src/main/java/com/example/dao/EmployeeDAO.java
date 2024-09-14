package com.example.dao;

import java.util.List;

import com.example.model.Employee;

public interface EmployeeDAO {
    void saveEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    void updateEmployee(Employee employee);
    void deleteEmployeeById(Long id);
    List<Employee> getAllEmployees();
}

