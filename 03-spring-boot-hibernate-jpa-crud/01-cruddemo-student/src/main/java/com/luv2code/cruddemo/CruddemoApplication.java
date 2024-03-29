package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (StudentDAO studentDAO){
		return runner -> {
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);


		};

	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);

	}

	private void deleteStudent(StudentDAO studentDAO) {
		/*retrieve student deleting*/
		int studentId = 2;
		System.out.println("Deleting student with id: " + studentId);

		/*delete student*/
		studentDAO.delete(studentId);

		List<Student> students = studentDAO.findAll();
		for (Student student : students){
			System.out.println(student);
		}

	}

	private void updateStudent(StudentDAO studentDAO) {
		/*retrieve student based on id: primary key*/
		int studentId = 1;
		System.out.println("Getting student with id of " + studentId);
		Student student = studentDAO.findById(studentId);

		/*change first name*/
		System.out.println("Updating student...");
		student.setFirstName("Scooby");

		/*update student*/
		studentDAO.update(student);

		/*display the updated student*/
		System.out.println("Updated student: " + student);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		/*get a list of students*/
		List<Student> students = studentDAO.findByLastName("04");

		/*display list of students*/
		for (Student student : students){
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		/*get a list of students*/
		List<Student> students = studentDAO.findAll();

		/*display list of students*/
		for (Student student : students){
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		/* create a student object	*/
		System.out.println("Creating student...");
		Student student = new Student("Student", "04", "student04@gmail.com");

		/* save the student	*/
		studentDAO.save(student);

		/* display id of student	*/
		int studentId = student.getId();
		System.out.println("Saved student id: " + studentId);

		/* retrieve student based on id	*/
		System.out.println("Retrieving student with id " + studentId );
		Student myStudent = studentDAO.findById(studentId);

		/* display student	*/
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		/* create multiple students	*/
		System.out.println("Creating multiple students...");
		Student student01 = new Student("Student", "01", "student01@gmail.com");
		Student student02 = new Student("Student", "02", "student02@gmail.com");
		Student student03 = new Student("Student", "03", "student03@gmail.com");

		/* save multiple students	*/
		System.out.println("Saving multiple students...");
		studentDAO.save(student01);
		studentDAO.save(student02);
		studentDAO.save(student03);
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
