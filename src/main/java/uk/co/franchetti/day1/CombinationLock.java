package uk.co.franchetti.day1;

// import java.util.regex.;

public class CombinationLock {
    // Attributes
    int minimum;
    int maximum;
    int current;
    // Pattern stepPattern = Pattern.compile("^[LR][0-9]+$");
    String stepRegex = "^[LR][0-9]+$";

    // Constructor
    public CombinationLock(int minimum, int maximum, int initial) {
        this.minimum = minimum;
        this.maximum = maximum;
        this.current = initial;
    }

    public void rotate(String step) {
        // Input string will be in the following format
        // Initial character with be L/R for rotation direction
        // Remaining characters will be digits and determine rotation distance
        // Matcher matcher = stepPattern.matcher(step);
        if (!step.matches(stepRegex)) {
            System.out.println("Input error!");
            return;
        }

        int distance = Integer.parseInt(step.substring(1));
        if (step.charAt(0) == 'L') {
            distance *= -1;
        }

        current += distance;

        while (current < minimum) {
            current = current + maximum - minimum +1;
        }
        while (current > maximum) {
            current = current - maximum + minimum - 1;
        }
    }

    public int getCurrent() {
        return current;
    }

    @Override
    public String toString() {
        return "Dial at " + this.getCurrent();
    }
}
