package com.thoughtworks.wallet;

import java.util.ArrayList;
import java.util.List;

public class Wallet {

    private final List<Currency> wallet = new ArrayList<>();

    public void deposit(Currency currency) throws NotAValidAmountException {
        if (currency.amount <= 0) throw new NotAValidAmountException("Amount is not Valid");
        wallet.add(currency);

    }


    public void retrieve(Currency currency) throws AmountNotPresentException {
        if (!(wallet.contains(currency))) throw new AmountNotPresentException("Amount is not present");
        wallet.remove(currency);

    }

    public double sum(Currency currency) {
        return currency.convert(wallet);
    }
}
