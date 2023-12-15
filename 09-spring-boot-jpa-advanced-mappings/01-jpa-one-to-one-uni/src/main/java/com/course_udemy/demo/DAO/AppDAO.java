package com.course_udemy.demo.DAO;

import com.course_udemy.demo.entity.Instructor;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);
}
