package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public Student findById(Integer id) {
        return  entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        /*create query*/
                                                        /*(Student) Name of JPA Entity, not database name
                                                           (lastName field of JPA Entity, not database field) */
        TypedQuery<Student> query = entityManager.createQuery("FROM Student ORDER BY lastName DESC", Student.class);

        /*return query results*/
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        /*create query*/
                                                                                /*JPQL named parameters prefixed by :*/
        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);

        /*set query parameters*/
        query.setParameter("theData", lastName);

        /*return query results*/
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        /*retrieve student*/
        Student student = entityManager.find(Student.class,id);

        /*delete student*/
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDeleted;
    }
}
