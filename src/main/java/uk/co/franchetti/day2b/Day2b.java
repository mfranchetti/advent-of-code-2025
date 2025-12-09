package uk.co.franchetti.day2b;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day2b {
    /*
     * Advent of Code 2025 Day 2 part 2
     * Invalid product IDs
     */
    public static void main(String[] args) throws IOException {
        String[] ranges = ProductID.fileToArray("src/main/resources/input-day2.txt");
        List<Long> invalidIds = new ArrayList<>();
        for (String r : ranges) {
            invalidIds.addAll(ProductID.getInvalidIds(r));
        }
        long total = invalidIds.stream().mapToLong(Long::longValue).sum();
        System.out.println("Result: " + total);

    }
}
