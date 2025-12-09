package uk.co.franchetti.day1b;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day1b {
    /*
     * Advent of Code 2025 Day 1 part 2
     * Combination lock
     */
    public static void main(String[] args) throws IOException {
        CombinationLock combinationLock = new CombinationLock( 50);
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/input-day1.txt"));
        String step;

        // System.out.println("Starting - " + combinationLock);
        while((step = reader.readLine()) != null) {
            combinationLock.rotate(step);
            // System.out.println(step + " " + combinationLock);
        }

        System.out.println("The password is " + combinationLock.getCounter() + ".");


    }
}