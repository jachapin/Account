/**
 * 
 * @author Jeff Chapin
 *
 */

/*
A private date data field named transactionDate for the Transaction
A private char data field named type for the Transaction. The value will be either W, D, P
A private double data field named amount for the Transaction
A private double data field named balance for the Transaction
A private String data field named description for the Transaction
An all-args constructor.
create a toString method that creates a string representing all of the fields 
 */
import java.text.DecimalFormat;
import java.util.*;

public class Transaction {
	
	DecimalFormat df = new DecimalFormat("$###,###.00");
	
	private Date transactionDate;
	private char type;
	private double amount;
	private double balance;
	private String description;
	
	Transaction(char type, double amount, double balance, String description) {
		transactionDate = new Date();
		this.type = type;
		this.amount = amount;
		this.balance = balance;
		this.description = description;
	}
	
	public String toString() {
		return "Transaction: transactionDate: " + this.transactionDate + ", type: " + this.type + ", amount: " + df.format(this.amount) + ", "
				+ "balance: " + df.format(this.balance) + ", description: " + this.description;
	}
	
}
