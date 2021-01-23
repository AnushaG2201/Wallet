package com.thoughtworks.wallet;

import java.util.ArrayList;
import java.util.List;

public class Wallet {


    private int amount;
    private List<Integer>wallet = new ArrayList<>();
    public Wallet(int amount) {
        this.amount = amount;
    }

    public void deposit() throws NotAValidAmountException {
        if(amount <= 0) throw new NotAValidAmountException("Amount is not Valid");
        wallet.add(amount);

    }


}
