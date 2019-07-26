import java.util.Date;

/**
 * 
 * @author Jeff Chapin
 *
 */


/*
A no-arg constructor that creates a default Loan.
A constructor that creates a loan with the specified id, the initial balance and name. This is a transaction.
A method named payment that withdraws a specified amount from the account. This is a transaction.
A method named getMonthlyInterestRate() that returns the monthly interest rate.
A method named getMonthlyInterest() that returns the monthly interest.
Monthly interest is balance * (1 + annualInterestRate/365)*30
monthlyInterestRate is annualInterestRate/12
create a toString method that creates a string representing all of the fields
 */



public class Loan extends AccountImpl implements Account  {
	
	Loan(int id, double balance, String name) {
		super(id, balance, name);
		Transaction transaction = new Transaction('W', balance, getBalance(), "New Loan");
		transactions.add(transaction);
	}
	
	Loan() {
		this(0, 0, "");
	}
	
	public void payment(double payment) {
		setBalance(getBalance() - payment);
		Transaction transaction = new Transaction('P', payment, getBalance(), "Payment");
		transactions.add(transaction);
	}
	
	public double getMonthlyInterestRate() {
		return getAnnualInterestRate() / 12;
	}
	
	public double getMonthlyInterest() {
		return getBalance() * getMonthlyInterestRate();
	}
	
	public String toString() {
		return "Loan: " + super.toString() + ", annualInterestRate: " + this.getAnnualInterestRate() + ", dateCreated: " + this.getDateCreated() + "\n\n";
	}
	
	
}
