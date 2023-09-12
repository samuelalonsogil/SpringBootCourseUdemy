package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (StudentDAO studentDAO){
		return runner -> {
			createStudent(studentDAO);
		};

	}

	private void createStudent(StudentDAO studentDAO) {
		/* create the student object */
		System.out.println("Creating new student...");
		Student student = new Student("Samuel", "Alonso", "samuelalonsogil@gmail.com");

		/* save the student object */
		System.out.println("Saving student...");
		studentDAO.save(student);

		/* display id of saving account */
		System.out.println("Student saved. Generated id: " + student.getId() );

	}

}
