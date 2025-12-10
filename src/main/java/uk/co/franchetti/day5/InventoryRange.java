package uk.co.franchetti.day5;

import java.util.Objects;

public class InventoryRange {
    // Attributes
    private Long minimum;
    private Long maximum;

    // Constructor
    public InventoryRange(Long minimum, Long maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public boolean contains(Long query) {
        return ((query >= minimum) && (query <= maximum));
    }

    public boolean overlaps(InventoryRange range) {
        return ((this.minimum <= range.maximum) && (this.maximum >= range.minimum));
    }

    public void merge(InventoryRange range) {
        this.minimum = Math.min(this.minimum, range.minimum);
        this.maximum = Math.max(this.maximum, range.maximum);
    }

    public Long size() {
        return maximum - minimum + 1;
    }

    @Override
    public String toString() {
        return minimum + " - " + maximum;
    }
}
