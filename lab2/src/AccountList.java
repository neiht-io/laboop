
import java.util.Arrays;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author khact
 */
import java.util.Arrays;


public class AccountList {
    private Account[] accList;
    private int count;

    public AccountList() {
        this(10);
    }

    public AccountList(int n) {
        if (n > 0) {
            accList = new Account[n];
        } else {
            accList = new Account[10];
        }
        count = 0;
    }
    
public boolean addAccount(Account account) {
    if (count < accList.length) {
        accList[count++] = account;
        return true;
    }
    return false;
}



    public Account findAccount(long accountNumber) {
        for (Account account : accList) {
            if (account != null && account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

public boolean removeAccount(long accountNumber) {
    Account accountToRemove = findAccount(accountNumber);
    if (accountToRemove != null) {
        for (int i = 0; i < count; i++) {
            if (accList[i] == accountToRemove) {
                accList[i] = accList[--count];
                accList[count] = null;
                return true;
            }
        }
    }
    return false;
}


    public int size() {
        return count;
    }

public void printAccountList() {
    for (Account account : accList) {
        if (account != null) {
            System.out.println(account.toString());
        }
    }
}

    public Account[] getAccounts() {
    return accList;
}


    @Override
    public String toString() {
        return "AccountList [accList=" + Arrays.toString(accList) + ", count=" + count + "]";
    }


}





