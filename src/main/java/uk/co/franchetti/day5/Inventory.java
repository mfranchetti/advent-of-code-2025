package uk.co.franchetti.day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Inventory {
    private final List<InventoryRange> fresh = new ArrayList<>();
    private final List<Long> available = new ArrayList<>();

    public Inventory(String filename) {
        // Input file is multiple lines with ranges representing fresh ingredients,
        // an empty line adn then multiple lines of single integers representing available stock
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String row;
            // Get fresh ingredients
            while(!(row = reader.readLine()).isEmpty()) {
                System.out.println(row);
                List<Long> range = Arrays.stream(row.split("-"))
                        .map(Long::parseLong)
                        .toList();
                add(new InventoryRange(range.getFirst(), range.getLast()));
            }
            // Get available ingredients
            while ((row = reader.readLine()) != null) {
                available.add(Long.parseLong(row));
            }
        } catch (IOException e) {
            // Ingredients will be empty
        }
    }

    public void add(InventoryRange range) {
        for (InventoryRange f : fresh) {
            if (f.overlaps(range)) {
                f.merge(range);
                reconcile();
                return;
            }
        }
        fresh.add(range);
    }

    private void reconcile() {
        for (int i = 0; i < fresh.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (fresh.get(j).overlaps(fresh.get(i))) {
                    fresh.get(j).merge(fresh.get(i));
                    fresh.remove(i);
                    i--;
                }
            }
        }
    }

    public List<Long> getFresh() {
        List<Long> output = new ArrayList<>();
        for (Long a : available) {
            for (InventoryRange f : fresh) {
                if (f.contains(a)) {
                    output.add(a);
                    break;
                }
            }
        }
        return output;
    }

    public Long getCountFreshIds() {
        Long count = 0L;
        for (InventoryRange f : fresh) {
            count += f.size();
        }
        return count;
    }

    @Override
    public String toString() {
        return "Inventory contains " + available.size() + " available items and " + fresh.size() + " fresh ranges.";
    }
}
