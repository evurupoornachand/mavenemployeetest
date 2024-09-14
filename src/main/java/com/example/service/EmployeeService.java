package com.example.service;

import java.util.List;

import com.example.dao.EmployeeDAO;
import com.example.model.Employee;

public class EmployeeService {

	    private EmployeeDAO employeeDAO;

	    public EmployeeService(EmployeeDAO employeeDAO) {
	        this.employeeDAO = employeeDAO;
	    }

	    public void addEmployee(Employee employee) {
	        employeeDAO.saveEmployee(employee);
	    }
	    
	    public Employee getEmployee(Long id) {
	        return employeeDAO.getEmployeeById(id);
	    }

	    public List<Employee> getAllEmployees() {
	        return employeeDAO.getAllEmployees();
	    }
	    
	    public void updateEmployee(Employee employee) {
	    	employeeDAO.updateEmployee(employee);
		}
	    
	    public void deleteEmployeeById(Long id) {
	    	employeeDAO.deleteEmployeeById(id);
	    }
}
