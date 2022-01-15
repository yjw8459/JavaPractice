package test;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class PredicateTest {

    static void test(){

        final String TEST = "Java";
        final int NUMBER = 9;
        Predicate<String> predicate = str -> str.equals("Java");
        IntPredicate intPredicate = num -> num > 10;

        boolean strTest = predicate.test(TEST);
        boolean numberTest = intPredicate.test(NUMBER);

        System.out.println("Predicate : " + strTest);
        System.out.println("IntPrecicate: " + numberTest);

    }

    public static void main(String[] args) {
        test();
    }

}
