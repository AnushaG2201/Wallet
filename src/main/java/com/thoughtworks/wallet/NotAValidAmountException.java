package com.thoughtworks.wallet;

public class NotAValidAmountException extends Exception {
    public NotAValidAmountException(String message) {
        super(message);
    }
}
