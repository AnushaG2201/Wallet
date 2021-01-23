package com.thoughtworks.wallet;

import java.util.ArrayList;
import java.util.List;

public class Wallet {



    private List<Integer>wallet = new ArrayList<>();


    public void deposit(int amount) throws NotAValidAmountException {
        if(amount <= 0) throw new NotAValidAmountException("Amount is not Valid");
        wallet.add(amount);

    }


    public void retrieve(int amount) throws AmountNotPresentException {
        if(!(wallet.contains(amount))) throw new AmountNotPresentException("Amount is not present");
        wallet.remove(new Integer(amount));

    }
}
