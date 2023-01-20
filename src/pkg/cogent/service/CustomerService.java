/**
 * 
 */
package pkg.cogent.service;

import pkg.cogent.dao.CustomerDAO;

/**
 * @author: Joi
 * @date: Jan 18, 2023
 */
public class CustomerService {
	CustomerDAO dao;
	public CustomerService() {
		dao = new CustomerDAO();
	}
	
	public void save() {
		dao.create();
	}
	
	public void fetch() {
		dao.read();
	}
	
	public void modify(int cId) {
		dao.update(cId);
	}
	
	public void delete(int cId) {
		dao.delete(cId);
	}
	
	public void search(int cId) {
		dao.findCustomerById(cId);
	}
	
	public void youngestCustomer() {
		dao.findYoungestCustomer();
	}
}
