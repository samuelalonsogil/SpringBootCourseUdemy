package com.course_udemy.demo.DAO;

import com.course_udemy.demo.entity.Instructor;
import com.course_udemy.demo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDAOImpl implements AppDAO{

    /*define field for entity manager*/
    private EntityManager entityManager;

    /*inject entity manager using constructor injection*/
    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        /*because of cascade this will also save a details instructor object*/
        entityManager.persist(instructor);
    }

    /*this will also retrieve the instructor details object
    because default behaviour of @OneToONe fetch type is eager*/
    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class, id);

    }

    @Transactional
    @Override
    public void deleteInstructorById(int id) {
        /*retrieve instructor*/
        Instructor instructor = entityManager.find(Instructor.class, id);

        /*delete instructor*/
         entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Transactional
    @Override
    public void deleteInstructorDetailById(int id) {
        /*retrieve instructor detail*/
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);

        /*remove the associated object reference break bidirectional link*/
        instructorDetail.getInstructor().setInstructorDetail(null);

        /*delete instructor*/
        entityManager.remove(instructorDetail);
    }

}
