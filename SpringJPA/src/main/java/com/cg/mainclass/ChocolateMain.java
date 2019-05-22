package com.cg.mainclass;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.chocolatedto.Chocolate;
import com.cg.chocolateexception.ChocolateException;
import com.cg.chocolateservice.ChocolateServiceImpl;

public class ChocolateMain {
	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	ChocolateServiceImpl chocolate_service = ctx.getBean(ChocolateServiceImpl.class);
	static Logger logger = Logger.getLogger(ChocolateMain.class);

	// ChocolateServiceImpl chocolate_service=new ChocolateServiceImpl();
	public void addChocolate() {
		try {
			logger.info("Inside Add Chocolate method");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Chocolate ID: ");
			int chocolate_id = sc.nextInt();
			System.out.println("Enter Chocolate name: ");
			String chocolate_name = sc.next();
			System.out.println("Enter Chocolate Description");
			String chocolate_description = sc.next();
			System.out.println("Enter Chocolate price");
			int chocolate_price = sc.nextInt();
			Chocolate chocolate = new Chocolate(chocolate_id, chocolate_name, chocolate_description, chocolate_price);
			chocolate_service.addChocolateService(chocolate);
			logger.info("Returned from Add Service method");
			System.out.println("Succesfully added");
		}

		catch (InputMismatchException ex) {
			throw new ChocolateException("Please give correct input");
		}
	}

	public void deleteChocolate() {
		try {
			logger.info("Inside Delete chocolate method");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Chocolate ID: ");
			int chocolate_id = sc.nextInt();
			chocolate_service.deleteChocolateService(chocolate_id);
			logger.info("Returned from Delete Service method");
			System.out.println("Deleted Succesfully");
		} catch (InputMismatchException ex) {
			throw new ChocolateException("Please give correct input");
		}
	}

	public void viewChocolate() {
		try {
			logger.info("Inside view chocolate method");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Chocolate ID: ");
			int chocolate_id = sc.nextInt();
			Chocolate chocolate = chocolate_service.viewChocolateService(chocolate_id);
			System.out.println("Chocolate ID: " + chocolate.getChocolate_id() + " Name: "
					+ chocolate.getChocolate_name() + " Description: " + chocolate.getChocolate_description()
					+ " Price: " + chocolate.getChocolate_price());
			logger.info("Displayed Chocolate value");
		} catch (InputMismatchException ex) {
			throw new ChocolateException("Please give correct input");
		}

	}

	public void updateChocolate() {
		try {
			logger.info("Inside Update chocolate method");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Chocolate ID: ");
			int chocolate_id = sc.nextInt();
			System.out.println("Enter Updated Price: ");
			int chocolate_price = sc.nextInt();
			chocolate_service.updateChocolateService(chocolate_id, chocolate_price);
			logger.info("Returned from Update Service method");
			System.out.println("Updated Succesfully");
		} catch (InputMismatchException ex) {
			throw new ChocolateException("Please give correct input");
		}

	}

	public void viewAllChocolate() {
		try {
			logger.info("Inside View All chocolate method");
			List<Chocolate> chocolates = chocolate_service.viewAllChocolate();
			for (Chocolate choc : chocolates) {
				System.out.println("Chocolate ID: " + choc.getChocolate_id() + " Name: " + choc.getChocolate_name()
						+ " Description: " + choc.getChocolate_description() + " Price: " + choc.getChocolate_price());

			}
			logger.info("Displayed all values");
		} catch (InputMismatchException ex) {
			throw new ChocolateException("Please give correct input");
		}
	}

	public static void main(String[] args) {
		int choice = 0;

		ChocolateMain chocolate = new ChocolateMain();
		while (choice != 6) {
			System.out.println("Welcome to Dark's Chocolate Shop");
			System.out.println("1. Add chocolate");
			System.out.println("2. View chocolate");
			System.out.println("3. Delete chocolate");
			System.out.println("4. Update chocolate");
			System.out.println("5. View all chocolate");
			System.out.println("6. Exit");
			System.out.println("Enter your choice");
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				try {
					chocolate.addChocolate();
					logger.info("Done with Add case");
				} catch (ChocolateException e) {
					System.out.println(e.getMessage());
					logger.error("Exception in Add method");
				}
				break;
			case 2:
				try {
					chocolate.viewChocolate();
					logger.info("Done with View ID case");
				} catch (ChocolateException e) {
					System.out.println(e.getMessage());
					logger.error("Exception in View ID method");
				}
				break;
			case 3:
				try {
					chocolate.deleteChocolate();
					logger.info("Done with Delete case");
				} catch (ChocolateException e) {
					System.out.println(e.getMessage());
					logger.error("Exception in Delete method");
				}
				break;
			case 4:
				try {
					chocolate.updateChocolate();
					logger.info("Done with Update case");
				} catch (ChocolateException e) {
					System.out.println(e.getMessage());
					logger.error("Exception in Update method");
				}
				break;
			case 5:
				try {
					chocolate.viewAllChocolate();
					logger.info("Done with View all case");
				} catch (ChocolateException e) {
					System.out.println(e.getMessage());
					logger.error("Exception in View all method");
				}
				break;
			case 6:
				System.out.println("See you soon!");
				logger.info("Done with exit case");

				return;
			default:
				System.out.println("Wrong choice, please enter again");

				break;
			}

		}

	}
}
