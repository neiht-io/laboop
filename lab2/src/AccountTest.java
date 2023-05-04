/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author khact
 */
import java.util.ArrayList;
    import java.util.Scanner;
public class AccountTest {



    private static Scanner scanner = new Scanner(System.in);
    private static AccountList accountList;
    


    public static void main(String[] args) {
        accountList = new AccountList();
        showMenu();
    }

    private static void showMenu() {
        int choice = 0;
        do {
            System.out.println("====== ACCOUNT MANAGEMENT SYSTEM ======");
            System.out.println("1. Add account");
            System.out.println("2. Get number of accounts");
            System.out.println("3. Print all accounts");
            System.out.println("4. Deposit money");
            System.out.println("5. Withdraw money");
            System.out.println("6. Transfer money");
            System.out.println("7. Exit");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addAccount();
                    break;
                case 2:
                    getNumberOfAccounts();
                    break;
                case 3:
                    printAllAccounts();
                    break;
                case 4:
                    depositMoney();
                    break;
                case 5:
                    withdrawMoney();
                    break;
                case 6:
                    transferMoney();
                    break;
                case 7:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 7);
    }

    private static void addAccount() {
        System.out.println("Enter account number:");
        long accountNumber = scanner.nextLong();
        scanner.nextLine(); // consume leftover newline character
        System.out.println("Enter account name:");
        String accountName = scanner.nextLine();
        System.out.println("Enter balance:");
        double balance = scanner.nextDouble();
        Account account = new Account(accountNumber, accountName, balance);
        if (accountList.addAccount(account)) {
            System.out.println("Account added successfully.");
        } else {
            System.out.println("Account could not be added.");
        }
    }

    private static void getNumberOfAccounts() {
        System.out.println("Number of accounts: " + accountList.size());
    }

private static void printAllAccounts() {
    Account[] accounts = accountList.getAccounts();
    for (Account account : accounts) {
        if (account != null) {
            System.out.println(account);
            System.out.println("-------------------------");
        }
    }
}


    private static void depositMoney() {
        System.out.println("Enter account number:");
        long accountNumber = scanner.nextLong();
        System.out.println("Enter amount to deposit:");
        double amount = scanner.nextDouble();

        Account account = accountList.findAccount(accountNumber);
        if (account != null) {
            account.deposit(amount);
            System.out.println("Deposit succeeded.");
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void withdrawMoney() {
        System.out.println("Enter account number:");
        long accountNumber = scanner.nextLong();
        System.out.println("Enter amount to withdraw:");
        double amount = scanner.nextDouble();

        Account account = accountList.findAccount(accountNumber);
        if (account != null) {
            account.withdraw(amount);
            System.out.println("Withdrawal succeeded.");
        } else {
            System.out.println("Account not found.");
        }
    }

   private static void transferMoney() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter sender account number:");
    long senderAccountNumber = scanner.nextLong();
    System.out.println("Enter receiver account number:");
    long receiverAccountNumber = scanner.nextLong();
    System.out.println("Enter transfer amount:");
    double amount = scanner.nextDouble();
    
    Account senderAccount = accountList.findAccount(senderAccountNumber);
    if (senderAccount == null) {
        System.out.println("Sender account not found.");
        return;
    }
    
    Account receiverAccount = accountList.findAccount(receiverAccountNumber);
    if (receiverAccount == null) {
        System.out.println("Receiver account not found.");
        return;
    }
    
    if (senderAccount.getBalance() < amount) {
        System.out.println("Insufficient balance.");
        return;
    }
    
    senderAccount.withdraw(amount);
    receiverAccount.deposit(amount);
    
    System.out.println("Transfer completed.");
}




    
    
}
