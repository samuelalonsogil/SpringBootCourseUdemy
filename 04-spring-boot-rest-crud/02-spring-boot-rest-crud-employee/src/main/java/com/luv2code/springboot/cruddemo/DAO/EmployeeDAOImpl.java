package com.luv2code.springboot.cruddemo.DAO;

import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    /*define field for entity manager*/
    private EntityManager entityManager;

    /*set up constructor injection*/
    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        /*create a query*/
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);

        /*execute query and result list*/
        List<Employee> employees = query.getResultList();

        /*return the results*/
        return employees;
    }

    @Override
    public Employee findById(int id) {
        /*get employee */
        Employee employee = entityManager.find(Employee.class, id);
        /*return employee */
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        /*save employee*/       /*if id == 0 insert/save else update*/
        Employee dbEmployee = entityManager.merge(employee);
        /*return employee*/
        return dbEmployee;
    }

    @Override
    public void delete(int id) {
        /*get employee */
        Employee employee = entityManager.find(Employee.class, id);
        if (employee == null) throw new RuntimeException("Employee id not found - " + id);
        /*delete employee*/
        entityManager.remove(employee);
    }
}
