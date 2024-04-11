package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ConcurrentBank {

    private List<BankAccount> accountList= new ArrayList();

    public BankAccount createAccount (BigDecimal sum) {

        BankAccount newAccount= new BankAccount(sum);
        accountList.add(newAccount);
        return newAccount;
    }

    public BankAccount createAccount () {

        BankAccount newAccount= new BankAccount();
        accountList.add(newAccount);
        return newAccount;
    }

    public synchronized String transfer (BankAccount accountDeposit, BankAccount accountWithdraw, BigDecimal sum) {
        accountDeposit.deposit(sum);
        accountWithdraw.withdraw(sum);
        return "deposite to account id = " + accountDeposit.getId()
                + "withdraw to account id = " + accountWithdraw.getId()
                + "sum = " + sum;
    }

    public BigDecimal getTotalBalance() {
        BigDecimal totalSum = BigDecimal.valueOf(0);
        for(BankAccount account :accountList) {
            BigDecimal temp = totalSum.add(account.getBalance());
            totalSum = temp;

        }
        return totalSum;
    }
}
