package com.course_udemy.demo;

import com.course_udemy.demo.DAO.AppDAO;
import com.course_udemy.demo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner->{
			System.out.println("hello world!");
			//createCourseAndStudents(appDAO);
			//findCourseAndStudents(appDAO);
			//findStudentsAndCourse(appDAO);
			//addMoreCoursesForStudent(appDAO);
			//deleteCourseById(appDAO);
			deleteStudent(appDAO);
		};
	}

	private void deleteStudent(AppDAO appDAO) {
		int id = 1;
		System.out.println("Deleting student id: " + id);
		appDAO.deleteStudentById(id);
		System.out.println("Done! ");

	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {
		int id = 2;
		Student student = appDAO.findStudentsAndCoursesByStudentsId(id);

		Course course01 = new Course("Guitar Hero ");
		Course course02 = new Course("Atari games ");
		Course course03 = new Course("Skate lessons ");

		student.addCourse(course01);
		student.addCourse(course02);
		student.addCourse(course03);

		System.out.println("Updating student: " + student);
		System.out.println("courses: " + student.getCourses());

		appDAO.update(student);

		System.out.println("Done! ");

	}

	private void findStudentsAndCourse(AppDAO appDAO) {
		int id = 1;

		System.out.println("Finding student id: " + id);

		Student student = appDAO.findStudentsAndCoursesByStudentsId(id);

		System.out.println("Student: " + student);
		System.out.println("Courses: " + student.getCourses() );

		System.out.println("Done! "  );
	}

	private void findCourseAndStudents(AppDAO appDAO) {
		int id = 10;

		System.out.println("Finding course id: " + id);

		Course course = appDAO.findCourseAndStudentsByCourseId(id);

		System.out.println("Course: " + course);
		System.out.println("Students: " + course.getStudents() );

		System.out.println("Done! "  );
	}

	private void createCourseAndStudents(AppDAO appDAO) {
		/* create course */
		Course course = new Course("Gym Training");

		/* create students */
		Student student01 = new Student("Samuel", "Alonso Gil", "samuel@mail.com");
		Student student02 = new Student("Noa", "Costas", "noa@mail.com");
		Student student03 = new Student("Zoe", "Costas", "zoe@mail.com");

		/* add students to the course */
		course.addStudent(student01);
		course.addStudent(student02);
		course.addStudent(student03);

		/* save the course and associate the students */
		System.out.println("Saving the course: " + course);
		System.out.println("Saving the students: " + course.getStudents());

		appDAO.save(course);

		System.out.println("Done!");
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int id = 10;
		System.out.println("Delete course with ID: " + id);

		/*will delete course and associated reviews because of cascade  */
		appDAO.deleteCourse(id);

		System.out.println("Done! ");
	}

	private void findCourseAndReviewsByCourseId(AppDAO appDAO) {
		int id = 10;

		System.out.println("Finding instructor id: " + id);

		Course course = appDAO.findCourseAndReviewsById(id);

		System.out.println("Course: " + course);
		System.out.println("Reviews: " + course.getReviews() );

		System.out.println("Done! "  );
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		/* create course */
		Course course = new Course("Running course");

		System.out.println("new course");

		/* add some reviews */
		course.addReview(new Review(" Great! ") );
		course.addReview(new Review(" Awesome! ") );
		course.addReview(new Review(" Bad! ") );

		System.out.println("saving course");
		System.out.println("course: " + course);
		System.out.println(course.getReviews());

		/* save course */
		appDAO.save(course);
	}

	private void deleteCourseById(AppDAO appDAO) {
		int id = 10;
		System.out.println("Deleting course ID: " + id);
		appDAO.deleteCourse(id);
		System.out.println("Done! ");
	}


	private void updateCourse(AppDAO appDAO) {
		/*  */
		int id = 10;
		Course course = appDAO.findCourseById(id);
		System.out.println("Course: " + course);

		course.setTitle("programming");

		appDAO.update(course);

		System.out.println("New data: " + course);
		System.out.println("Done! ");
	}

	private void updateInstructor(AppDAO appDAO) {
		/*  */
		int id = 1;
		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("Instructor: " + instructor);

		instructor.setFirstName("Samu");
		instructor.setLastName("Alonso");
		instructor.setEmail("samu@gmail.com");

		appDAO.update(instructor);

		System.out.println("New data: " + instructor);
		System.out.println("Done! ");

	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int id = 1;

		System.out.println("Finding instructor id: " + id);

		Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);

		System.out.println("Instructor: " + instructor);
		System.out.println("Courses: " + instructor.getCourses() );

		System.out.println("Done! "  );
	}

	private void findCoursesByInstructorId(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor id: " + id);
		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("Instructor: " + instructor);

		/* find courses for  instructor */
		System.out.println("finding courses for instructor id");
		List<Course> courses = appDAO.findCoursesByInstructorId(id);
		instructor.setCourses(courses);

		System.out.printf("associated courses " + instructor.getCourses() );
		System.out.println("Done!");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor id: " + id);
		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("Instructor: " + instructor);
		System.out.println("associated courses: " + instructor.getCourses());
		System.out.println("Done!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		/*create the instructor*/
		Instructor instructor = new Instructor("Antia", "Fandiño", "antia@gmail.com");

		/*create instructor detail*/
		InstructorDetail instructorDetail = new InstructorDetail("www.antia.com","being cool");

		/*associate the objects*/
		instructor.setInstructorDetail(instructorDetail);

		/*create some courses*/
		Course course = new Course("guitar");
		Course course02 = new Course("bass");
		Course course03 = new Course("drums");

		/*add courses to instructor*/
		instructor.add(course);
		instructor.add(course02);
		instructor.add(course03);

		/*save instructor (this will also save tge courses)*/
		System.out.println("Saving instructor: " + instructor);
		System.out.println("Courses: " + instructor.getCourses());
		appDAO.save(instructor);

		System.out.println("Done!");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int id = 3;
		System.out.println("Finding instructor detail id: " + id);
		appDAO.deleteInstructorDetailById(id);

		System.out.println("Done! "  );
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int id = 2;
		System.out.println("Finding instructor id: " + id);
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);
		System.out.println("Instructor Details: " + instructorDetail);
		System.out.println("Instructor: " + instructorDetail.getInstructor() );
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor id: " + id);
		appDAO.deleteInstructorById(id);

		System.out.println("Done! "  );
	}

	private void findInstructor(AppDAO appDAO) {
		int id = 2;
		System.out.println("Finding instructor id: " + id);
		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("Instructor: " + instructor);
		System.out.println("Instructor Details: " + instructor.getInstructorDetail() );
	}

	private void createInstructor(AppDAO appDAO) {
		/*create the instructor*/
		Instructor instructor = new Instructor("Antia", "Fandiño", "antia@gmail.com");
		
		/*create instructor detail*/
		InstructorDetail instructorDetail = new InstructorDetail("www.antia.com","being cool");
		
		/*associate the objects*/
		instructor.setInstructorDetail(instructorDetail);

		/*save instructor*/
		/*this will also save the details object because of CascadeType.ALL*/
		System.out.println("Instructor: " + instructor);
		appDAO.save(instructor);

		System.out.println( " DONE! " );
		
	}


}
