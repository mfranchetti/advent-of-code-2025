package uk.co.franchetti.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductID {
    /*
     * Methods for handling Product IDs
     */

    public static String[] fileToArray (String filename) throws IOException {
        // Input file is a single line with product ID ranges separated by commas.
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        return reader.readLine().split(",");
    }

    public static List<Long> getInvalidIds (String range) {
        List<Long> invalidIds = new ArrayList<>();
        long[] minMax = Arrays.stream(range.split("-"))
                .mapToLong(Long::parseLong)
                .toArray();
        for (long i = minMax[0]; i <= minMax[1]; i++) {
            String productID = String.valueOf(i);
            if (productID.substring(0, (productID.length()/2)).equals(productID.substring((productID.length()/2)))) {
                invalidIds.add(i);
            }
        }
        return invalidIds;
    }
}
