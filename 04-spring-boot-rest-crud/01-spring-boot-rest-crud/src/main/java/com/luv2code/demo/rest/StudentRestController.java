package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    /*define @PostConstruct to load the student data ... only once!*/
    @PostConstruct
    public void loadData(){
        students = new ArrayList<>();

        students.add(new Student("Student","01"));
        students.add(new Student("Student","02"));
        students.add(new Student("Student","03"));
    }

    /*define endpoint for "/students" - return a list of students*/
    @GetMapping("/students")
    public List<Student> getStudents(){ return students; }

    /*define endpoint for "/students/{studentId}" - return student at index*/
    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId){

        /*check the studentId again*/
        if( (studentId>= students.size() ) || (students.size() < 0 )){
            throw new StudentNotFoundException( "Student ID not found - " + studentId );
        }

        return students.get(studentId);
    }




}
