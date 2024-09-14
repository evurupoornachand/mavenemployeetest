package com.ex;

import com.example.model.Employee;
import com.example.service.EmployeeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

        EmployeeService employeeService = context.getBean("employeeService", EmployeeService.class);

      
        Employee employee = new Employee();
        employee.setName("poorna");
        employee.setDesignation("Developer");
        employee.setSalary(50000.0);
        employeeService.addEmployee(employee);

        
        employeeService.getAllEmployees().forEach(emp -> System.out.println(emp.getName()));

        
        employee.setSalary(55000.0);
        employeeService.updateEmployee(employee);

       
        employeeService.deleteEmployee(employee.getId());
    }
}