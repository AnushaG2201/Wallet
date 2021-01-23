package com.thoughtworks.wallet;

public class AmountNotPresentException extends Throwable {
    public AmountNotPresentException(String amount_is_not_present) {
        super(amount_is_not_present);
    }
}
