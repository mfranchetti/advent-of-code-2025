package uk.co.franchetti.day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day1 {
    /*
     * Advent of Code 2025 Day 1
     * Combination lock
     */
    public static void main(String[] args) throws IOException {
        CombinationLock combinationLock = new CombinationLock(0, 99, 50);
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/input-day1.txt"));
        String step;
        int count = 0;

        System.out.println("Starting - " + combinationLock);
        while((step = reader.readLine()) != null) {
            combinationLock.rotate(step);
            if (combinationLock.getCurrent() == 0) {
                count++;
            }
        }

        System.out.println("The password is " + count + ".");


    }
}