package com.example.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.dao.EmployeeDAO;
import com.example.model.Employee;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    
    private EntityManagerFactory entityManagerFactory;

    public EmployeeDAOImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    private EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    @Override
    public void saveEmployee(Employee employee) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(employee);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        EntityManager em = getEntityManager();
        Employee employee = em.find(Employee.class, id);
        em.close();
        return employee;
    }

    @Override
    public void updateEmployee(Employee employee) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(employee);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void deleteEmployeeById(Long id) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Employee employee = em.find(Employee.class, id);
        if (employee != null) {
            em.remove(employee);
        }
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Employee> getAllEmployees() {
        EntityManager em = getEntityManager();
        List<Employee> employees = em.createQuery("FROM Employee", Employee.class).getResultList();
        em.close();
        return employees;
    }
}
