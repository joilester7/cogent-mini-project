/**
 * 
 */
package pkg.cogent.controller;

import java.util.Scanner;

import pkg.cogent.service.CustomerService;

/**
 * @author: Joi
 * @date: Jan 18, 2023
 */
public class CustomerController {
	
	CustomerService cs;
	Scanner sc = new Scanner(System.in);
	
	public CustomerController() {
		cs = new CustomerService();
	}
	
	public void accept(int choice) {
		switch(choice) {
		case 1:
			cs.save();
			break;
		case 2:
			cs.fetch();
			break;
		case 3:
			System.out.println("Please enter the customer ID");
			int cId = sc.nextInt();
			cs.modify(cId);
			break;
		case 4:
			System.out.println("Please enter the customer ID");
			int id = sc.nextInt();
			cs.delete(id);
			break;
		case 5:
			cs.youngestCustomer();
			break;
		case 6: 
			System.out.println("Please enter customer ID");
			int no = sc.nextInt();
			cs.search(no);
		}
		
	}
}
