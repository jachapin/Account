/**
 * 
 * @author Jeff Chapin
 *
 */

/*
A no-arg constructor that creates a default Savings.
A constructor that creates a savings with the specified id, the initial balance and name. This is a transaction.
A method named withdraw that withdraws a specified amount from the account. This is a transaction.
A method named deposit that deposits a specified amount to the account. This is a transaction.
A method named getMonthlyInterestRate() that returns the monthly interest rate.
A method named getMonthlyInterest() that returns the monthly interest.
Monthly interest is balance * monthlyInterestRate
monthlyInterestRate is annualInterestRate/12
create a toString method that creates a string representing all of the field
 */

public class Savings extends AccountImpl implements Account {
	
	// Constructors
	Savings(int id, double balance, String name) {
		super(id, balance, name);
		Transaction transaction = new Transaction('D', balance, getBalance(), "New Savings");
		transactions.add(transaction);
	}
	
	Savings() {
		this(0, 0, "");
	}
	

	public void withdraw (double withdrawal) {
		setBalance(getBalance() - withdrawal);
		Transaction transaction = new Transaction('W', withdrawal, getBalance(), "Withdrawal");
		transactions.add(transaction);
	}
	
	public void deposit (double deposit) {
		setBalance(getBalance() + deposit);
		Transaction transaction = new Transaction('D', deposit, getBalance(), "Deposit");
		transactions.add(transaction);
	}
	
	public double getMonthlyInterestRate() {
		return getAnnualInterestRate() / 12;
	}
	
	public double getMonthlyInterest() {
		return getBalance() * getMonthlyInterestRate();
	}
	
	public String toString() {
		return "Savings: " + super.toString() + ", annualInterestRate: " + getAnnualInterestRate() + ", dateCreated: " + getDateCreated();
	}
	
}
