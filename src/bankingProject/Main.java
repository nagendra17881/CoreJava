package bankingProject;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1.Create Account");
            System.out.println("2.Deposit");
            System.out.println("3.Withdraw");
            System.out.println("4.Transfer");
            System.out.println("5.Check Balance");
            System.out.println("6.Transaction History");
            System.out.println("7.Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Enter Account No:");
                    int accNo = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Name:");
                    String name = sc.nextLine();
                    System.out.println("Enter Initial Balance:");
                    double bal = sc.nextDouble();

                    bank.createAccount(new SavingsAccount(accNo, name, bal));
                    break;


                case 2:
                    System.out.println("Account No:");
                    accNo = sc.nextInt();
                    System.out.println("Amount:");
                    bank.getAccount(accNo).deposit(sc.nextDouble());
                    break;

                case 3:
                    System.out.println("Account No:");
                    accNo = sc.nextInt();
                    System.out.println("Amount:");
                    bank.getAccount(accNo).withdraw(sc.nextDouble());
                    break;

                case 4:
                    System.out.println("From Account:");
                    int from = sc.nextInt();
                    System.out.println("To Account:");
                    int to = sc.nextInt();
                    System.out.println("Amount:");
                    double amount = sc.nextDouble();
                    bank.transfer(from, to, amount);
                    break;

                case 5:
                    System.out.println("Account No:");
                    accNo = sc.nextInt();
                    System.out.println("Balance: " +
                            bank.getAccount(accNo).getBalance());
                    break;

                case 6:
                    System.out.println("Account No:");
                    accNo = sc.nextInt();
                    bank.getAccount(accNo).getTransactions().forEach(System.out::println);
                    break;

                case 7:
                    System.exit(0);
            }
        }
      
    }
}