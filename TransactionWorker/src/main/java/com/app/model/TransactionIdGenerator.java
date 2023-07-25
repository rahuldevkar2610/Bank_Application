package com.app.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.security.SecureRandom;
public class TransactionIdGenerator {

	private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int LENGTH = 10;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    private static SecureRandom random = new SecureRandom();

    public static String generateTransactionId() {
        StringBuilder sb = new StringBuilder();
        LocalDateTime now = LocalDateTime.now();
        sb.append(now.format(FORMATTER));

        for (int i = 0; i < LENGTH; i++) {
            int randomIndex = random.nextInt(ALPHABET.length());
            sb.append(ALPHABET.charAt(randomIndex));
        }

        return sb.toString();
    }
}
