package com.course_udemy.demo.DAO;

import com.course_udemy.demo.entity.Course;
import com.course_udemy.demo.entity.Instructor;
import com.course_udemy.demo.entity.InstructorDetail;
import com.course_udemy.demo.entity.Student;

import java.util.List;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstructorId(int id);

    Instructor findInstructorByIdJoinFetch(int id);

    void update(Instructor instructor);

    void update(Course course);

    Course findCourseById(int id);

    void deleteCourse(int id);

    void save(Course course);

    Course findCourseAndReviewsById(int id);

    Course findCourseAndStudentsByCourseId(int id);

}
