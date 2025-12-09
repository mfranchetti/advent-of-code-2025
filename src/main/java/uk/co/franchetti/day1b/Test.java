package uk.co.franchetti.day1b;

import java.io.IOException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        CombinationLock combinationLock = new CombinationLock(50);
        List<String> steps = List.of("R49", "R1", "R1", "L1", "L1", "R1", "R100", "R200", "L100", "L200");

        System.out.println("Starting - " + combinationLock);
       for (String step : steps) {
            combinationLock.rotate(step);
            System.out.println(step + " " + combinationLock);
        }

        System.out.println("The password is " + combinationLock.getCounter() + ".");


    }
}