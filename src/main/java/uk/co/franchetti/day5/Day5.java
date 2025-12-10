package uk.co.franchetti.day5;

public class Day5 {
    /*
     * Advent of Code 2025 Day 5
     * Cafeteria
     */
    public static void main(String[] args) {
        Inventory inventory = new Inventory("src/main/resources/input-day5.txt");
        System.out.println(inventory);
        System.out.println("Fresh items: " + inventory.getFresh().size());
        System.out.println("Count of fresh IDs: " + inventory.getCountFreshIds());
    }
}
