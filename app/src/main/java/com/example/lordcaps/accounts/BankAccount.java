package com.example.lordcaps.accounts;

import java.util.ArrayList;

/**
 * Created by LordCaps on 14/07/2015.
 */

public abstract class BankAccount {


    private static final String TAG = "BankAccount";
    private ArrayList<Double> mTransactions;
    public static final double OVERDRAFT_FEE = 30;

    BankAccount() {
        mTransactions = new ArrayList<Double>();
    }

    public void withdraw(double amount) {

        mTransactions.add(-amount);
        //Check if the balance has gone negative to apply overdraftfee
        if(getBalance() < 0) {
            mTransactions.add(-OVERDRAFT_FEE);
        }
    }

    public void deposit(double amount) {
        mTransactions.add(amount);
    }

    protected int numberOfWithdraws() {
        int count = 0;
        for (int i = 0; i < mTransactions.size(); i++) {
            if(mTransactions.get(i) < 0) ++count;
        }
        return count;
    }

    public double getBalance() {
        double total = 0;
        for(int i = 0; i < mTransactions.size();++i) {
            total+=mTransactions.get(i);
        }
        return total;
    }

}
