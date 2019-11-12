package com.geely.design.pattern.structural.bridge.impl;

import com.geely.design.pattern.structural.bridge.Account;
import com.geely.design.pattern.structural.bridge.Bank;

/**
 * Created by geely
 */
public class ICBCBank extends Bank {
    public ICBCBank(Account account) {
        super(account);
    }

    @Override
    public Account openAccount() {
        System.out.println("打开中国工商银行账号");
        account.openAccount();
        return account;
    }
}
