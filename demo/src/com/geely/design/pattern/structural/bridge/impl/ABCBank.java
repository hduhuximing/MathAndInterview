package com.geely.design.pattern.structural.bridge.impl;

import com.geely.design.pattern.structural.bridge.Account;
import com.geely.design.pattern.structural.bridge.Bank;

/**
 * Created by geely
 */
public class ABCBank extends Bank {
    public ABCBank(Account account) {
        super(account);
    }

    @Override
    public Account openAccount() {
        System.out.println("打开中国农业银行账号");
        account.openAccount();
        return account;
    }
}
