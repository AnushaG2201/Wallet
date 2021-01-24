package com.thoughtworks.wallet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WalletTest {
    @Test
    void shouldAllowDepositInWalletIfAmountIsGreaterThanZero() {
        Wallet wallet = new Wallet();
        Rupees rupee = new Rupees(10);

        assertDoesNotThrow(() -> wallet.deposit(rupee));

    }

    @Test
    void shouldReturnExceptionIfAmountIsZero() {
        Wallet wallet = new Wallet();
        Rupees rupee = new Rupees(0);

        assertThrows(NotAValidAmountException.class, () -> wallet.deposit(rupee));
    }

    @Test
    void shouldReturnTheSpecifiedAmountIfAvailable() throws NotAValidAmountException {
        Wallet wallet = new Wallet();
        Rupees rupee = new Rupees(10);

        wallet.deposit(rupee);

        assertDoesNotThrow(() -> wallet.retrieve(rupee));

    }

    @Test
    void shouldReturnExceptionIfAmountNotAvailable() throws NotAValidAmountException {
        Wallet wallet1 = new Wallet();
        Rupees rupee1 = new Rupees(10);
        Rupees rupee2 = new Rupees(20);

        wallet1.deposit(rupee1);

        assertThrows(AmountNotPresentException.class, () -> wallet1.retrieve(rupee2));
    }

    @Test
    void shouldReturnTotalAmountIfPreferredCurrencyIsRupee() throws NotAValidAmountException {
        Wallet wallet = new Wallet();
        Rupees rupee = new Rupees(50);
        Dollars dollars = new Dollars(1);

        wallet.deposit(rupee);
        wallet.deposit(dollars);
        double result = wallet.sum(rupee);

        assertEquals(124.5, result, 0.001);
    }

    @Test
    void shouldReturnTotalAmountIfPreferredCurrencyIsDollar() throws NotAValidAmountException {

        Wallet wallet1 = new Wallet();
        Rupees rupee1 = new Rupees(74.85);
        Rupees rupee2 = new Rupees(149.7);
        Dollars dollars = new Dollars(1);

        wallet1.deposit(rupee1);
        wallet1.deposit(rupee2);
        wallet1.deposit(dollars);
        double result = wallet1.sum(dollars);

        assertEquals(4, result, 0.1);
    }


}

