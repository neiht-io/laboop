
import java.text.NumberFormat;
import java.util.Locale;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author khact
 */

    import java.text.NumberFormat;
import java.util.Locale;

public class Account {
    private long accountNumber;
    private String accountName;
    private double balance;
    private String status;
    private static final double INTEREST_RATE = 0.035;

    public Account() {
        this(999999, "Chưa xác định", 50);
    }

    public Account(long accountNumber, String accountName, double balance) {
        setAccountNumber(accountNumber);
        setAccountName(accountName);
        setBalance(balance);
    }

    public long getAccountNumber() {
        return accountNumber;
    }

public void setAccountNumber(long accountNumber) {
    this.accountNumber = (accountNumber > 0 && accountNumber != 999999) ? accountNumber : 999999;
    status = (accountNumber > 0 && accountNumber != 999999) ? "" : "Invalid account number. Set to default value.";
}


    public String getAccountName() {
        return accountName;
    }

public void setAccountName(String accountName) {
    this.accountName = accountName.isEmpty() ? "Chưa xác định" : accountName;
    status = accountName.isEmpty() ? "Account name cannot be empty. Set to default value." : "";
}


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance >= 50) {
            this.balance = balance;
            status = "";
        } else {
            this.balance = 50;
            status = "Balance must be at least 50. Set to default value.";
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            status = "Deposit succeeded.";
        } else {
            status = "Deposit failed. Amount must be greater than 0.";
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            status = "Withdrawal succeeded.";
        } else {
            status = "Withdrawal failed. Amount must be greater than 0 and less than or equal to balance.";
        }
    }

    public void transfer(Account toAccount, double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            toAccount.deposit(amount);
            status = "Transfer succeeded.";
        } else {
            status = "Transfer failed. Amount must be greater than 0 and less than or equal to balance.";
        }
    }

    public void accrueInterest() {
        balance += balance * INTEREST_RATE;
        status = "Interest accrued.";
    }

    @Override
    public String toString() {
        Locale locale = new Locale("vi", "VN");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        String balanceFormatted = formatter.format(balance);
        return "Account number: " + accountNumber + "\nAccount name: " + accountName + "\nBalance: " + balanceFormatted + "\nStatus: " + status;
    }
}
