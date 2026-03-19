package BankingProject;

import java.io.*;
import java.util.HashMap;

public class Bank {

	    private HashMap<Integer, Account> accounts = new HashMap<>();
	    private final String FILE_NAME = "bankdata.ser";
	
	    public Bank() {
	        loadData();
	    }
	
	    public void createAccount(Account account) {
	    		if(accounts.containsKey(account.getAccountNumber()))
	    			System.out.println("account already exists");
	    		else {
	    			accounts.put(account.getAccountNumber(), account);
	    	        saveData();
	    	        System.out.println("Account Created Successfully!");
	    		}
	        
	    }
	
	    public Account getAccount(int accNo) {
	        return accounts.get(accNo);
	    }
	
	    public void transfer(int fromAcc, int toAcc, double amount) {
	
	        Account sender = accounts.get(fromAcc);
	        Account receiver = accounts.get(toAcc);
	
	        if (sender == null || receiver == null) {
	            System.out.println("Invalid Account Number!");
	            return;
	        }
	
	        if (amount <= 0) {
	            System.out.println("Invalid Amount!");
	            return;
	        }
	
	        if (amount > sender.getBalance()) {
	            System.out.println("Insufficient Balance!");
	            return;
	        }
	
	        sender.withdraw(amount);
	        receiver.deposit(amount);
	
	        saveData();
	        System.out.println("Transfer Successful!");
	    }
	
	    private void saveData() {
	        try (ObjectOutputStream oos =
	                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
	            oos.writeObject(accounts);
	        } catch (IOException e) {
	            System.out.println("Error Saving Data!");
	        }
	    }
	
	    private void loadData() {
	        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))){
	            accounts = (HashMap<Integer, Account>) ois.readObject();
	        } 
	        catch (Exception e) {
	            accounts = new HashMap<>();
	        }
    }
}
