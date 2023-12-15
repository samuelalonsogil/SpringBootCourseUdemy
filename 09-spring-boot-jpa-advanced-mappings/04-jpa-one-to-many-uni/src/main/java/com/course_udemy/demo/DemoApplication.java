package com.course_udemy.demo;

import com.course_udemy.demo.DAO.AppDAO;
import com.course_udemy.demo.entity.Course;
import com.course_udemy.demo.entity.Instructor;
import com.course_udemy.demo.entity.InstructorDetail;
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

		};
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
