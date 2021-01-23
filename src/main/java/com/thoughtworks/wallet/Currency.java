package com.thoughtworks.wallet;

import java.util.List;

public abstract class Currency {
    double amount;

    public Currency(double amount) {
        this.amount = amount;
    }

    abstract double convert(List<Currency> wallet);

}
