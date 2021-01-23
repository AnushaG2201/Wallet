package com.thoughtworks.wallet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class WalletTest {
    @Test
    void shouldAllowDepositInWalletIfAmountIsGreaterThanZero() {
        Wallet wallet = new Wallet(1);

        assertDoesNotThrow(()->wallet.deposit());

    }

    @Test
    void shouldReturnExceptionIfAmountIsZero() {
        Wallet wallet = new Wallet(0);

        assertThrows(NotAValidAmountException.class,()->wallet.deposit());
    }

}
