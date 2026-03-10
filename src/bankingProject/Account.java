package bankingProject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Account implements Serializable {

		    private int accountNumber;
		    private String holderName;
		    protected double balance;
		    protected List<Transaction> transactions = new ArrayList<>();
		
		    public Account(int accountNumber, String holderName, double balance) {
		        this.accountNumber = accountNumber;
		        this.holderName = holderName;
		        this.balance = balance;
		    }
		
		    public int getAccountNumber() {
		        return accountNumber;
		    }
		
		    public String getHolderName() {
		        return holderName;
		    }
		
		    public double getBalance() {
		        return balance;
		    }
		
		    public List<Transaction> getTransactions() {
		        return transactions;
		    }
		
		    public abstract void deposit(double amount);
		    public abstract void withdraw(double amount);
		}