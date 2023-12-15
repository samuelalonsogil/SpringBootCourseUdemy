package com.course_udemy.demo.DAO;

import com.course_udemy.demo.entity.Instructor;
import com.course_udemy.demo.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);
}
