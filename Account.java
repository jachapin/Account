/**
 * 
 * @author Jeff Chapin
 *
 */

/*
 * 
A method name getName that returns a String
A method named getId that returns an int
A method named getBalance returns a double
A method setAnnualInterestRate(double rate) that returns void
A method getAnnualInterestRate that returns a double
A method getDateCreated returns a Date object
A method named getMonthlyInterestRate() that returns the monthly interest rate.
A method named getMonthlyInterest() that returns the monthly interest.
A method addInterest that returns a void
 */


public interface Account {
	
	public String getName();
	
	public int getId();
	
	public double getBalance();
	
	public void setAnnualInterestRate(double annualInterestRate);
	
	public double getAnnualInterestRate();
	
	public java.util.Date getDateCreated();
	
	public double getMonthlyInterestRate();
	
	public double getMonthlyInterest();
	
	public void addInterest();
}
