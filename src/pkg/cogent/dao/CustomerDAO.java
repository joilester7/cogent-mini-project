/**
 * 
 */
package pkg.cogent.dao;


import java.util.Scanner;
import pkg.cogent.exception.MandatoryFieldException;
import pkg.cogent.model.Customer;
import pkg.cogent.model.Date;

/**
 * @author: Joi
 * @date: Jan 18, 2023
 */
public class CustomerDAO implements CustomerDAOImpl {
	Customer customers[];
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void create() {
		System.out.println("How many customers do you want to store?");
		int size = sc.nextInt();
		customers = new Customer[size];
		for(int i = 0; i < customers.length; i++) {
			Customer c = new Customer();
			System.out.println("Please enter customer ID");
			int id = sc.nextInt();
			System.out.println("Please enter customer name");
			String cName = sc.next();
			System.out.println("Please enter customer email");
			String cEmail = sc.next();
			System.out.println("Please enter customer's Date of Birth");
			System.out.println("Please enter customer's birth month in mm format");
			int month = sc.nextInt();
			System.out.println("Please enter customer's birth day in dd format");
			int day = sc.nextInt();
			System.out.println("Please enter customer's birth year in yyyy format");
			int year = sc.nextInt();
			Date date = new Date(month, day, year);
			
			c.setcId(id);
			c.setcName(cName);
			c.setcEmail(cEmail);
			c.setcDOB(date);
			
			validateMandatoryField(c);
			customers[i] = c;
		}
		
	}
	
	public void validateMandatoryField(Customer customer) {
		if(customer == null) {
			throw new MandatoryFieldException("Customer object cannot be left blank");
		} else if(customer.getcId() == 0) {
			throw new MandatoryFieldException("Customer ID cannot be left blank");
		}
	}
	
	@Override
	public void read() {
		for(int i = 0; i < customers.length; i++) {
			System.out.println("Customer ID: " + customers[i].getcId());
			System.out.println("Customer Name: " + customers[i].getcName());
			System.out.println("Customer Email: " + customers[i].getcEmail());
			customers[i].getcDOB().datesToString();
			System.out.println();
			System.out.println();
		}
		
	}

	@Override
	public void update(int cId) {
		int id = sc.nextInt();
		
		for(int i = 0; i < customers.length; i++) {
			if(id == customers[i].getcId()) {
				System.out.println("1 - Update customer's name");
				System.out.println("2 - Update customer's email");
				System.out.println("Please enter a choice");
				int choice = sc.nextInt();
				switch(choice) {
				case 1:
					System.out.println("Please enter customer's new name");
					String cName = sc.next();
					customers[i].setcName(cName);
					break;
				case 2:
					System.out.println("Please enter customer's new email");
					String cEmail = sc.next();
					customers[i].setcEmail(cEmail);
					break;
				}
			}
		}
	}

	@Override
	public void delete(int cId) {
		int size = customers.length;
		Customer newCustomers[] = new Customer[size - 1];
		for(int i = 0, j = 0; i < customers.length; i++) {
			if(cId != customers[i].getcId()) {
				newCustomers[j] = customers[i];
				j++;
			}
		}
		System.out.println("Customer deleted successfully");
		customers = newCustomers;
		
	}

	@Override
	public void findCustomerById(int cId) {
		for(int i = 0; i < customers.length; i++) {
			if(cId == customers[i].getcId()) {
				System.out.println();
				System.out.println("Customer does exist");
				System.out.println("Customer ID: " + customers[i].getcId());
				System.out.println("Customer Name: " + customers[i].getcName());
				System.out.println("Customer Email: " + customers[i].getcEmail());
				customers[i].getcDOB().datesToString();
			}
		}
	}

	@Override
	public void findYoungestCustomer() {
		Customer temp = null;
		for(int i = 0; i < customers.length; i++) {
			for(int j = i+1; j <customers.length; j++) {
				if(customers[i].getcDOB().getYear() > customers[j].getcDOB().getYear()) {
					temp = customers[i];
					customers[i] = customers[j];
					customers[j] = temp;
				}
			}	
		}
		System.out.println("The youngest customer is " + temp.getcName());
			
	}

}
