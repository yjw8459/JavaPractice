package stream;

import java.util.Arrays;
import java.util.Comparator;

public class SortedTest {

    public static void sortedTest(){

        Arrays.asList(1, 2, 3, 4, 5).stream()
                .sorted().forEach(System.out::println);
        Arrays.asList(1, 2, 3, 4, 5).stream()
                .sorted(Comparator.reverseOrder()).forEach(System.out::println);

        Arrays.asList(
                        new Score( 40, 80, 23 ),
                        new Score( 61, 88, 100 ),
                        new Score( 94, 30, 77 )
                ).stream().sorted(Comparator.comparing(Score::getKor))
                .forEach(score -> System.out.println(score.getKor()));
    }
}
