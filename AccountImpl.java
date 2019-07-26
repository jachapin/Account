/**
 * 
 * @author Jeff Chapin
 *
 */


/*
A private String data field named name for the account(default "")
A private int data field named id for the account(default 0)
A private double data field named balance for the account(default 0)
A private ArrayList data field named transactions that stores the transactions for the accounts. Each transaction is an instance of the Transaction class.
A private double data field named annualInterestRate that stores the current interest rate (default 0).
A private Date data field named dateCreated that stores the date when the account was created.
A no-arg constructor that creates a default AccountImpl.
A constructor that creates an accountImpl with the specified id, the initial balance and name.
In the constructors, use the Calendar object to set the dateCreated to Aug. 13, 2018
The accessor and mutator methods for name, id, balance, and annualInterestRate.
The accessor method for dateCreated.
An abstract method named getMonthlyInterestRate() that returns the monthly interest rate.
An abstract method named getMonthlyInterest() that returns the monthly interest.
A method named addInterest that uses getMonthlyInterest to increase the balance. Returns void. This is a transaction.
create a toString method that creates a string representing all of the fields
 */

import java.util.*;
import java.text.DecimalFormat;

public abstract class AccountImpl {
	
	DecimalFormat df = new DecimalFormat("$###,###.00");
	
	// Data fields
	private String name;
	private int id;
	private double balance;
	private double annualInterestRate = 0;
	protected ArrayList<Transaction> transactions = new ArrayList<>();
	private Date dateCreated = new Date();
	
	// Constructor
	AccountImpl(int id, double balance, String name) {
		setId(id);
		setBalance(balance);
		setName(name);
		dateCreated = new GregorianCalendar(2018, 9, 13).getTime();
	}

	// No-arg constructor sets default values for id, balance, and name
	AccountImpl() {
		this(0, 0, "");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	
	public Date getDateCreated() {
		return this.dateCreated;
	}
	
	/** Abstract methods */
	public abstract double getMonthlyInterestRate();
	
	public abstract double getMonthlyInterest();
	
	/** Add monthlyInterest to balance */
	public void addInterest() {
		balance += getMonthlyInterest();
		Transaction transaction = new Transaction('D', balance, getBalance(), "Monthly Interest");
		transactions.add(transaction);
		
	}
	
	public String returnArrayList() {
		String arL = null;
		for(Transaction t: transactions) 
			arL += t + "\n";
		
		return arL;
	}
	
	public String toString() {
		return " name: " + getName() + ", id: " + getId() + ", balance: " + df.format(getBalance()) + ", transactions: [\n" + returnArrayList() + "]";
	}
	
	
}
