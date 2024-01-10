package com.demo.appdemo;

import com.demo.appdemo.DAO.AccountDAO;
import com.demo.appdemo.DAO.MemberShipDAO;
import com.demo.appdemo.service.TrafficFortuneService;
import org.aspectj.lang.annotation.Before;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AOPdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AOPdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO,
											   MemberShipDAO memberShipDAO,
											   TrafficFortuneService trafficFortuneService){
		return runner->{
			//beforeAdvice(accountDAO,memberShipDAO);
			//afterReturningAdvice(accountDAO);
			//afterThrowingAdvice(accountDAO);
			//afterAdvice(accountDAO);
			//aroundAdvice(trafficFortuneService);
			//aroundAdviceHandleException(trafficFortuneService);
			aroundAdviceReThrowException(trafficFortuneService);

		};
	}

	private void aroundAdviceReThrowException(TrafficFortuneService trafficFortuneService) {
		boolean tripWire = true;
		System.out.println("Main Program: aroundAdviceReThrowException" + "\n" + "calling getFortune()");
		System.out.println("My fortune is" + trafficFortuneService.getFortune(tripWire));
		System.out.println("Done!");
	}

	private void aroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {
		boolean tripWire = true;
		System.out.println("Main Program: aroundAdviceHandleException" + "\n" + "calling getFortune()");
		System.out.println("My fortune is" + trafficFortuneService.getFortune(tripWire));
		System.out.println("Done!");
	}

	private void aroundAdvice(TrafficFortuneService trafficFortuneService) {
		System.out.println("Main Program: aroundAdvice" + "\n" + "calling getFortune()");
		System.out.println("My fortune is" + trafficFortuneService.getFortune());
		System.out.println("Done!");
	}

	private void afterAdvice(AccountDAO accountDAO) {
		List<Account> accounts = null;
		try{
			/* add a boolean flag to simulate the exceptions */
			boolean tripWire = false;
			accounts = accountDAO.findAccounts(tripWire);
		}catch (Exception exception){
			System.out.println("Main app exception caught: " + exception );
		}
		System.out.println("Main app afterThrowingAdvice" + "\n" + " Accounts retrieved: " + "\n" + accounts);
	}

	private void afterThrowingAdvice(AccountDAO accountDAO) {
		List<Account> accounts = null;
		try{
			/* add a boolean flag to simulate the exceptions */
			boolean tripWire = true;
			accounts = accountDAO.findAccounts(tripWire);
		}catch (Exception exception){
			System.out.println("Main app exception caught: " + exception );
		}
		System.out.println("Main app afterThrowingAdvice" + "\n" + " Accounts retrieved: " + "\n" + accounts);
	}

	private void afterReturningAdvice(AccountDAO accountDAO) {
		/* call method to find the accounts */
		System.out.println("Main app Accounts retrieved: " + "\n" + accountDAO.findAccounts());
	}


	private void beforeAdvice(AccountDAO accountDAO, MemberShipDAO memberShipDAO) {
		Account account = new Account();
		account.setName("samu");
		account.setLevel("diamond");

		/*call the accountDao getter and setters*/
		accountDAO.setName("foobar");
		accountDAO.setServiceCode("silver");

		String name = accountDAO.getName();
		String serviceCode = accountDAO.getServiceCode();

		accountDAO.addAccount(account, true);
		memberShipDAO.addSilly();
		memberShipDAO.goToSleep();
		accountDAO.doWork();
	}



}
