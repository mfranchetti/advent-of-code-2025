package uk.co.franchetti.day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    // Attributes
    private final char[][] warehouse;
    private final int rows;
    private final int cols;

    public Warehouse(String filename) {
        // Input file is multiple lines representing a warehouse map
        // Empty spaces are represented by periods . and rolls of paper by at @
        List<String> tempMap = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String row;
            while((row = reader.readLine()) != null) {
                tempMap.add(row);
            }
        } catch (IOException e) {
            // Warehouse will be empty
        }
        // Check for empty warehouse
        if (tempMap.isEmpty()) {
            rows = 0;
            cols = 0;
        } else {
            rows = tempMap.getFirst().length();
            cols = tempMap.size();
        }
        // Transcribe map to array
        warehouse = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            warehouse[i] = tempMap.get(i).toCharArray();
        }
    }

    public int getAccessible() {
        // Calculate the number of accessible rolls in the warehouse
        int accessible = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (isAccessible(r, c)) {
                    accessible++;
                }
            }
        }
        return accessible;
    }

    public int getRemovable() {
        // Create temporary warehouse that can be restored
        char[][] tmpWarehouse = new char[rows][];
        for (int r = 0; r < rows; r++) {
            tmpWarehouse[r] = this.warehouse[r].clone();
        }
        int removable = 0;
        int removed;
        do {
            removed = 0;
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (isAccessible(r, c)) {
                        warehouse[r][c] = '.';
                        removed++;
                    }
                }
            }
            removable += removed;
        } while (removed > 0);
        // Restore warehouse status
        for (int r = 0; r < rows; r++) {
            this.warehouse[r] = tmpWarehouse[r].clone();
        }
        return removable;
    }

    private boolean isAccessible(int row, int col) {
        // Check if a location is accessible
        // Locations are accessible if there are less than four occupied in the eight surrounding locations
        if (warehouse[row][col] != '@') {
            // Location is empty
            return false;
        }
        // Set boundaries
        int rMin = Math.max(row-1, 0);
        int rMax = Math.min(row+2, rows);
        int cMin = Math.max(col-1, 0);
        int cMax = Math.min(col+2, cols);
        // Check all locations
        int occupied = 0;
        for (int r = rMin; r < rMax; r++) {
            for (int c = cMin; c < cMax; c++) {
                if (warehouse[r][c] == '@') {
                    occupied++;
                }
            }
        }
        // We've counted the checked location itself which adds one to the count
        return occupied < 5;
    }

    public int getSize() {
        return rows * cols;
    }

    @Override
    public String toString() {
        return "The warehouse contains " + getSize() + " locations arranged in " + rows + " rows and " + cols + " columns.";
    }
}
