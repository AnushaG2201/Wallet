package com.thoughtworks.wallet;

import java.util.List;

public class Rupees extends Currency {
    double sum;

    public Rupees(double amount) {
        super(amount);
    }

    @Override
    public double convert(List<Currency> wallet) {
        for (Currency currency : wallet) {
            if (currency instanceof Dollars)
                sum += currency.amount * 74.5;
            else
                sum += currency.amount;

        }
        return sum;
    }

}
