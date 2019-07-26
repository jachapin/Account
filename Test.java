/**
 * 
 * @author Jeff Chapin
 *
 */
/*
 * Write a test program that prompts the user in a loop to create an Account.
 * 
creates a Saving object with an accountID of 1122, a balance of $20,000, and an annual interest rate of 4.5%.

Use the withdraw method to withdraw $2500 and the use the deposit method to deposit $3000. Next use the addInterest method to add the monthly interest.

creates a Loan object with an accountID of 2018, a balance of $20,000, and an annual interest rate of 4.5%.

Use the payment method to pay $500. Next use the addInterest method to add the monthly interest.

Finally use an enhanced for loop and call the toString method on all of the accounts. Example output below.

Example output:

What Type of account, enter ‘L’ for Loan or ‘S’ for Savings account?
s
Account Id?
1122
Initial Balance?
20000
Account Name?
boat_savings
Annual Interest Rate?
.045
What Type of Transaction, enter ‘W’ for withdraw, ‘D’ for Deposit, or 'P' for payment?
w
Transaction amount?
2500
Enter another Transaction, enter ‘Y’ for yes?
y
What Type of Transaction, enter ‘W’ for withdraw, ‘D’ for Deposit, or 'P' for payment?
D
Transaction amount?
3000
Enter another Transaction, enter ‘Y’ for yes?
n
Enter another Account, enter ‘Y’ for yes?
y
What Type of account, enter ‘L’ for Loan or ‘S’ for Savings account?
l
Account Id?
2018
Initial Balance?
20000
Account Name?
car_loan
Annual Interest Rate?
.045
What Type of Transaction, enter ‘W’ for withdraw, ‘D’ for Deposit, or 'P' for payment?
p
Transaction amount?
500
Enter another Transaction, enter ‘Y’ for yes?
n
Enter another Account, enter ‘Y’ for yes?
n
Savings: name:'boat_savings', id: 1122, balance: $20,576.88, transactions: [
Transaction: transactionDate:Sat Sep 08 11:02:48 CDT 2018, type:D, amount:$.00, balance:$20,000.00, description:New Savings, 
Transaction: transactionDate:Sat Sep 08 11:02:56 CDT 2018, type:W, amount:$2,500.00, balance:$17,500.00, description:Withdrawal, 
Transaction: transactionDate:Sat Sep 08 11:03:21 CDT 2018, type:D, amount:$3,000.00, balance:$20,500.00, description:Deposit, 
Transaction: transactionDate:Sat Sep 08 11:04:38 CDT 2018, type:D, amount:$77.16, balance:$20,576.88, description:Monthly Interest]
, annualInterestRate: 0.045, dateCreated: Mon Aug 13 00:00:00 CDT 2018

Loan: name:'car_loan', id: 2018, balance: $19,530.00, transactions: [
Transaction: transactionDate:Sat Sep 08 11:04:24 CDT 2018, type:D, amount:$.00, balance:$20,000.00, description:New Loan, 
Transaction: transactionDate:Sat Sep 08 11:04:30 CDT 2018, type:P, amount:$500.00, balance:$19,500.00, description:Payment, 
Transaction: transactionDate:Sat Sep 08 11:04:38 CDT 2018, type:D, amount:$30.00, balance:$19,530.00, description:Monthly Interest]
, annualInterestRate: 0.045, dateCreated: Mon Aug 13 00:00:00 CDT 2018
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        List<Account> accountList = new ArrayList<>();
        String more;
        do {
            System.out.println("What Type of account, enter ‘L’ for Loan or ‘S’ for Savings account?");
            String accountType = input.next();
            System.out.println("Account Id?");
            int accountId = input.nextInt();
            System.out.println("Initial Balance?");
            double balance = input.nextDouble();
            System.out.println("Account Name?");
            String name = input.next();
            System.out.println("Annual Interest Rate?");
            double apr = input.nextDouble();
            Account account;

            if ("L".equalsIgnoreCase(accountType)) {
                account = new Loan(accountId, balance, name);

            } else if ("S".equalsIgnoreCase(accountType)) {
                account = new Savings(accountId, balance, name);
            } else {
                System.out.println(accountType + " is not a valid type of account");
                break;
            }
            account.setAnnualInterestRate(apr);
            accountList.add(account);
            enterTransactions(account);
            System.out.println("Enter another Account, enter ‘Y’ for yes?");
            more = input.next();

        } while ("Y".equalsIgnoreCase(more));

        addInterestAccounts(accountList);
        printAccounts(accountList);
    }

    private static void enterTransactions(Account account) {
        String more;
        do {
            System.out.println("What Type of Transaction, enter ‘W’ for withdraw, ‘D’ for Deposit, or 'P' for payment?");
            String transactionType = input.next();
            System.out.println("Transaction amount?");
            double transactionAmount = input.nextDouble();

            switch (transactionType.toUpperCase()) {
                case "W":
                    ((Savings) account).withdraw(transactionAmount);
                    break;
                case "D":
                    ((Savings) account).deposit(transactionAmount);
                    break;
                case "P":
                    ((Loan) account).payment(transactionAmount);
                    break;
                default:
                    System.out.printf("Transaction Type %s is not supported", transactionType);
            }
            System.out.println("Enter another Transaction, enter ‘Y’ for yes?");
            more = input.next();
        } while ("Y".equalsIgnoreCase(more));
    }
    
    private static void addInterestAccounts(List<Account>accountList){
        for (Account account : accountList) {
            account.addInterest();
        }
    }
    
    private static void printAccounts(List<Account>accountList){
        for (Account account : accountList) {
            System.out.println(account.toString());
            System.out.println();
        }
    }
}
