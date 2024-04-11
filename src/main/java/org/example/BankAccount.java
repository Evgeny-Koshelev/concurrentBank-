package org.example;

import java.math.BigDecimal;
import java.util.UUID;

public class BankAccount {

    private UUID id;
    private BigDecimal balance;

    public BankAccount () {
        id = UUID.randomUUID();
        balance = BigDecimal.valueOf(0);
    }

    public BankAccount (BigDecimal balance) {
        id = UUID.randomUUID();
        this.balance = balance;
    }

    public UUID getId() {
        return id;
    }

    public synchronized String deposit(BigDecimal sum) {

       BigDecimal temp = balance.add(sum);
       balance = temp;
        return "deposit = " + sum;
    }

    public synchronized String withdraw (BigDecimal sum) {

        if(balance.compareTo(sum) < 0) {
            return "withdraw sum > balance";
        }
        else {
            BigDecimal temp = balance.subtract(sum);
            balance = temp;
            return "withdraw = " + sum;
        }
    }

    public synchronized BigDecimal getBalance () {
        return balance;
    }
}
