package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/*
-Specialized annotation for repositories
-Supports component scanning
-Translates JDBC exceptions
*/
@Repository
public class StudentDAOImpl implements StudentDAO{

    /* define field for EntityManager */
    private EntityManager entityManager;

    /*inject EntityManager using constructor injection*/
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /*implement save method*/
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }
}
