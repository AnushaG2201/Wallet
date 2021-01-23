package com.thoughtworks.wallet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class WalletTest {
    @Test
    void shouldAllowDepositInWalletIfAmountIsGreaterThanZero() {
        Wallet wallet = new Wallet();

        assertDoesNotThrow(()->wallet.deposit(1));

    }

    @Test
    void shouldReturnExceptionIfAmountIsZero() {
        Wallet wallet = new Wallet();

        assertThrows(NotAValidAmountException.class,()->wallet.deposit(0));
    }

    @Test
    void shouldReturnTheSpecifiedAmountIfAvailable() throws NotAValidAmountException {
        Wallet wallet = new Wallet();
        wallet.deposit(10);

        assertDoesNotThrow(()->wallet.retrieve(10));

    }

    @Test
    void shouldReturnExceptionIfAmountNotAvailable() throws NotAValidAmountException {
        Wallet wallet1 = new Wallet();
        wallet1.deposit(10);
        wallet1.deposit(20);

        assertThrows(AmountNotPresentException.class,()-> wallet1.retrieve(50));
    }
}
