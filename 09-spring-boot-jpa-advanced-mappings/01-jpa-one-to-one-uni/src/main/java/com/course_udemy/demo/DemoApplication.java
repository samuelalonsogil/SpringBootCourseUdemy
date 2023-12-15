package com.course_udemy.demo;

import com.course_udemy.demo.DAO.AppDAO;
import com.course_udemy.demo.entity.Instructor;
import com.course_udemy.demo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner->{
			System.out.println("hello world!");
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			deleteInstructor(appDAO);
		};
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
		Instructor instructor = new Instructor("Noa", "Costas", "noa@gmail.com");
		
		/*create instructor detail*/
		InstructorDetail instructorDetail = new InstructorDetail("www.noa.com","being pretty");
		
		/*associate the objects*/
		instructor.setInstructorDetail(instructorDetail);

		/*save instructor*/
		/*this will also save the details object because of CascadeType.ALL*/
		System.out.println("Instructor: " + instructor);
		appDAO.save(instructor);

		System.out.println( " DONE! " );
		
	}


}
