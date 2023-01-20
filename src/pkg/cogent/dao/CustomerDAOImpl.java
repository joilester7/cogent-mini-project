/**
 * 
 */
package pkg.cogent.dao;

/**
 * @author: Joi
 * @date: Jan 18, 2023
 */
public interface CustomerDAOImpl {
	public void create();
	public void read();
	public void update(int cId);
	public void delete(int cId);
	public void findCustomerById(int cId);
	public void findYoungestCustomer();
}
