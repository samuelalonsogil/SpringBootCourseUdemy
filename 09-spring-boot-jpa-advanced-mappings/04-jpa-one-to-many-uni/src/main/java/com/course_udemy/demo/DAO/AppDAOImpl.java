package com.course_udemy.demo.DAO;

import com.course_udemy.demo.entity.Course;
import com.course_udemy.demo.entity.Instructor;
import com.course_udemy.demo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

        /*get the courses*/
        List<Course> courses = instructor.getCourses();

        /*break association of all courses for the instructor*/
        for (Course course : courses){
            course.setInstructor(null);
        }

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

    @Override
    public List<Course> findCoursesByInstructorId(int id) {
        /*create query*/
        TypedQuery<Course> query = entityManager.createQuery("FROM Course WHERE instructor.id = :data", Course.class);
        query.setParameter("data", id);

        /*execute query*/
        List<Course> courses = query.getResultList();

        return courses;
    }

    /*even if the fetch is lazy we get the instructor and the courses because of the join fetch*/
    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        /*create query*/
        TypedQuery<Instructor> query = entityManager.createQuery(
                "SELECT i FROM Instructor i " +
                    "JOIN FETCH i.courses " +
                    "JOIN FETCH i.instructorDetail " +
                    "WHERE i.id = :data", Instructor.class);
        query.setParameter("data", id);

        /*execute query*/
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void update(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourseById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Transactional
    @Override
    public void deleteCourse(int id) {
        /* retrieve course */
        Course course = entityManager.find(Course.class, id);

        /*delete course*/
        entityManager.remove(course);
    }

}
