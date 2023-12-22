package com.demo.appdemo;

import com.demo.appdemo.DAO.AccountDAO;
import com.demo.appdemo.DAO.MemberShipDAO;
import org.aspectj.lang.annotation.Before;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AOPdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AOPdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MemberShipDAO memberShipDAO){
		return runner->{
			beforeAdvice(accountDAO,memberShipDAO);
		};
	}


	private void beforeAdvice(AccountDAO accountDAO, MemberShipDAO memberShipDAO) {
		/*call business method*/
		accountDAO.addAccount();

		/*call membership method*/
		memberShipDAO.addSilly();
	}


}
