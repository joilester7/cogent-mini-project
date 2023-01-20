/**
 * 
 */
package pkg.cogent.model;



/**
 * @author: Joi
 * @date: Jan 18, 2023
 */

public class Customer {
	private int cId;
	private String cName;
	private String cEmail;
	private Date cDOB;
	
	public Customer() {
		super();
		
	}

	public Customer(int cId, String cName, String cEmail, Date cDOB) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cEmail = cEmail;
		this.cDOB = cDOB;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcEmail() {
		return cEmail;
	}

	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}

	public Date getcDOB() {
		return cDOB;
	}

	public void setcDOB(Date cDOB) {
		this.cDOB = cDOB;
	}
	
}
