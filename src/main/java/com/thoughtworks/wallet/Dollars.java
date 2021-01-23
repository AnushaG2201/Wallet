package com.thoughtworks.wallet;

import java.util.List;

public class Dollars extends Currency {
    private double sum;
    public Dollars(int amount) {
        super(amount);
    }

    @Override
    public double convert(List<Currency> wallet) {
        for (Currency currency : wallet) {
            if (currency instanceof Rupee)
                sum += currency.amount/74.85;
            else
                sum += currency.amount;
        }
        return sum;
    }
}
