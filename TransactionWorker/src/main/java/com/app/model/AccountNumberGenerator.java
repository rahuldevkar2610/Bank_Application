package com.app.model;
import java.util.concurrent.atomic.AtomicInteger;
public class AccountNumberGenerator {

	private static final int MAX_ACCOUNT_NUMBER = 999999999; // Maximum 10-digit number

    private static AtomicInteger counter = new AtomicInteger(0);

    public static int generateAccountNumber() {
        int currentCounterValue = counter.incrementAndGet();

        if (currentCounterValue > MAX_ACCOUNT_NUMBER) {
            throw new IllegalStateException("Maximum account number limit reached.");
        }

        long timestamp = System.currentTimeMillis();

        int accountNumber = (int) (timestamp % 10000000000L); // Use the last 10 digits of the timestamp
        accountNumber = accountNumber * 1000 + currentCounterValue; // Append the counter value

        return accountNumber;
    }

}
