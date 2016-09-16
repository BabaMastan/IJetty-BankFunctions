package beans;

import java.util.Date;

public class CustomerInfo {

	private int accno;
	private String username;
	private String balance;
	private Date lastvisiteddate;
	
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public Date getLastvisiteddate() {
		return lastvisiteddate;
	}
	public void setLastvisiteddate(Date lastvisiteddate) {
		this.lastvisiteddate = lastvisiteddate;
	}
	
}
