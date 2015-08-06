package com.example.lordcaps.accounts;

import com.example.lordcaps.accounts.BankAccount;

/**
 * Created by LordCaps on 16/07/2015.
 */
public class SavingsAccount extends BankAccount {

    private static final String TAG = "SavingsAccount";

    @Override
    public void withdraw(double amount) {
        if(numberOfWithdraws() >= 3) {
            return;
        }
        super.withdraw(amount);
    }
}
