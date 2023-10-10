package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.DAO.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        /*'Optional' different pattern instead of having to check for nulls*/
        Optional<Employee> result = employeeRepository.findById(id);
        Employee employee = null;

        if (result.isPresent()) employee = result.get();
        else throw new RuntimeException("Did not find employee id - " + id);

        return employee;
    }

    /*no need for @Transactional since JpaRepository provides this functionality*/
    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }


    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}
