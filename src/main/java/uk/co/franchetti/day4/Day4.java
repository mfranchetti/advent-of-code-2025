package uk.co.franchetti.day4;

public class Day4 {
    /*
     * Advent of Code 2025 Day 4
     * Warehouse
     */
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse("src/main/resources/input-day4.txt");
        System.out.println(warehouse);
        System.out.println("Accessible items: " + warehouse.getAccessible());
        System.out.println("Removable items: " + warehouse.getRemovable());
    }
}
