package com.thoughtworks.wallet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WalletTest {
    @Test
    void shouldAllowDepositInWalletIfAmountIsGreaterThanZero() {
        Wallet wallet = new Wallet();
        Rupee rupee = new Rupee(10);

        assertDoesNotThrow(() -> wallet.deposit(rupee));

    }

    @Test
    void shouldReturnExceptionIfAmountIsZero() {
        Wallet wallet = new Wallet();
        Rupee rupee = new Rupee(0);

        assertThrows(NotAValidAmountException.class, () -> wallet.deposit(rupee));
    }

    @Test
    void shouldReturnTheSpecifiedAmountIfAvailable() throws NotAValidAmountException {
        Wallet wallet = new Wallet();
        Rupee rupee = new Rupee(10);

        wallet.deposit(rupee);

        assertDoesNotThrow(() -> wallet.retrieve(rupee));

    }

    @Test
    void shouldReturnExceptionIfAmountNotAvailable() throws NotAValidAmountException {
        Wallet wallet1 = new Wallet();
        Rupee rupee1 = new Rupee(10);
        Rupee rupee2 = new Rupee(20);

        wallet1.deposit(rupee1);

        assertThrows(AmountNotPresentException.class, () -> wallet1.retrieve(rupee2));
    }

    @Test
    void shouldReturnTotalAmountIfPreferredCurrencyIsRupee() throws NotAValidAmountException {
        Wallet wallet = new Wallet();
        Rupee rupee = new Rupee(50);
        Dollars dollars = new Dollars(1);

        wallet.deposit(rupee);
        wallet.deposit(dollars);
        double result = wallet.sum(rupee);

        assertEquals(124.5, result, 0.001);
    }

    @Test
    void shouldReturnTotalAmountIfPreferredCurrencyIsDollar() throws NotAValidAmountException {

        Wallet wallet1 = new Wallet();
        Rupee rupee1 = new Rupee(74.85);
        Rupee rupee2 = new Rupee(149.7);
        Dollars dollars = new Dollars(1);

        wallet1.deposit(rupee1);
        wallet1.deposit(rupee2);
        wallet1.deposit(dollars);
        double result = wallet1.sum(dollars);

        assertEquals(4, result, 0.1);
    }


}

