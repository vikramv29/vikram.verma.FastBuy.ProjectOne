package com.app;

import java.util.Scanner;

import org.apache.log4j.Logger;
import com.app.Exception.BusinessException;
import com.app.service.Customer;
import com.app.service.Employee;
import com.app.service.impl.CustomerImpl;
import com.app.service.impl.EmployeeImpl;

public class Main {
	private static Logger log = Logger.getLogger(Main.class) ;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		log.info("Welcome to FastBuy Online Shopping App");
		log.info("==========================================");

		int ch = 0;
		do {
			log.info("1)Login as Customer.");
			log.info("2)Login as an Employee");
			log.info("3)Register.");
			log.info("Please enter your choice(1-3)");
			try {
				ch = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				log.info("Entry is not appropriate. Please Enter Valid Choice\n");
			}
			switch(ch) {
		case 1:
			Employee employeeLogin = new EmployeeImpl();

				log.info("\n**** Welcome to Employee Login Portal****");
				log.info("Enter your username");
				String username = scanner.nextLine();
				log.info("Enter your password");
				String password = scanner.nextLine();
				try {
					boolean valid = employeeLogin.checkValidCredentials(username, password);
					if (valid) {
						log.info("Work under construction!!!");
					}
				} catch (BusinessException e) {
					System.out.println("Enter valid login credentials.");
				}
				break ;
		case 2: 
