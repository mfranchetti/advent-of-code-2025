package uk.co.franchetti.day1b;

// import java.util.regex.;

public class CombinationLock {
    // Attributes
    int minimum = 0;
    int maximum = 99;
    int current;
    int counter;
    // Pattern stepPattern = Pattern.compile("^[LR][0-9]+$");
    String stepRegex = "^[LR][0-9]+$";

    // Constructor
    public CombinationLock(int initial) {
        this.current = initial;
        this.counter = 0;
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

        for (int i = 0; i < distance; i++) {
            if (step.charAt(0) == 'R') {
                current++;
                if (current > maximum) {
                    current = minimum;
                }
            }
            if (step.charAt(0) == 'L') {
                current--;
                if (current < minimum) {
                    current = maximum;
                }
            }
            if (current == 0) {
                counter++;
            }
        }

    }

    public int getCurrent() {
        return current;
    }

    public int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return "Dial at " + this.getCurrent() + ", counter at " + this.getCounter() + ".";
    }
}
