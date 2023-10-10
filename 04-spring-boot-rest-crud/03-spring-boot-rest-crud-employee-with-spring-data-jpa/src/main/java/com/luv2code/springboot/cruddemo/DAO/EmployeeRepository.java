package com.luv2code.springboot.cruddemo.DAO;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
                                                            /*Entity, Primary Key*/
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    /*that's it, no need to write any code */
}
