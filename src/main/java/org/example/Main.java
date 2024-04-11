package org.example;

import java.math.BigDecimal;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ConcurrentBank bank = new ConcurrentBank();

        BankAccount account1 = bank.createAccount(BigDecimal.valueOf(1000));
        BankAccount account2 = bank.createAccount(BigDecimal.valueOf(500));

        Thread transferThread1 = new Thread(() -> System.out.println(bank.transfer(account1, account2, BigDecimal.valueOf(200))));
        Thread transferThread2 = new Thread(() -> System.out.println(bank.transfer(account2, account1, BigDecimal.valueOf(100))));

        transferThread1.start();
        transferThread2.start();

        try {
            transferThread1.join();
            transferThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Total balance: " + bank.getTotalBalance());
    }


}