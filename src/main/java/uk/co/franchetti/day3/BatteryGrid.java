package uk.co.franchetti.day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BatteryGrid {
    // Attributes
    private final List<String> banks = new ArrayList<>();

    public BatteryGrid(String filename) {
        // Input file is multiple lines of digits
        // Each row corresponds to a single bank of batteries
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String bank;
            while((bank = reader.readLine()) != null) {
                banks.add(bank);
            }
        } catch (IOException e) {
            // Battery grid will be empty or incomplete
        }
    }

    public static long getBankMax(String bank) {
        // if no length supplied, default to two
        return getBankMax(bank, 2);
    }

    public static long getBankMax(String bank, int digits) {
        // String of digits
        // Max value is the highest number, of length digits, that can be made without changing the order
        char[] bankMax = new char[digits];
        int start = 0;
        // Loop for each value
        for (int i = 0; i < digits; i++) {
            String substring = bank.substring(start, bank.length()-digits+i+1);
            bankMax[i] = getMax(substring);
            start += substring.indexOf(bankMax[i])+1;
        }
        // System.out.println(bank + ":" + String.valueOf(bankMax));
        // Return value
        return Long.parseLong(String.valueOf(bankMax));
    }

    private static char getMax(String bank) {
        int max = 0;
        for (int i = 0; i < bank.length(); i++) {
            if (Character.getNumericValue(bank.charAt(i)) > max) {
                max = Character.getNumericValue(bank.charAt(i));
            }
        }
        return (char)(max + '0');
    }

    public long getTotal() {
        long total = 0;
        for (String bank : banks) {
            total += getBankMax(bank);
        }
        return total;
    }

    public long getOverride() {
        long total = 0;
        for (String bank : banks) {
            total += getBankMax(bank, 12);
        }
        return total;
    }
}
