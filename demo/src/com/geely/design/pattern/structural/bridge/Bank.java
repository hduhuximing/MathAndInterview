package com.geely.design.pattern.structural.bridge;

/**
 * Created by geely
 */
public abstract class Bank {
    public Account account;

    public Bank(Account account) {
        this.account = account;
    }

    public abstract Account openAccount();

}
