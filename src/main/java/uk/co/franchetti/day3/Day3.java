package uk.co.franchetti.day3;

import java.util.List;

public class Day3 {
    /*
     * Advent of Code 2025 Day 3
     * Joltage
     */
    public static void main(String[] args) {
        BatteryGrid batteryGrid = new BatteryGrid("src/main/resources/input-day3.txt");
        // test();
        // Expected 17155
        System.out.println("Output joltage: " + batteryGrid.getTotal());
        System.out.println("Override joltage: " + batteryGrid.getOverride());
    }

    static void test() {
        List<String> testBanks = List.of("123456789", "987654321", "8899", "555444");
//        for (String bank : testBanks) {
//            System.out.println(bank + ":" + BatteryGrid.getBankMax(bank));
//        }
        for (String bank : testBanks) {
            System.out.println(bank + ":" + BatteryGrid.getBankMax(bank,3));
        }
    }
}
