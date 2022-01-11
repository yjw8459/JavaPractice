package stream;

import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Backup {

    static class Score{
        int kor;
        int eng;
        int math;

        Score(int kor, int eng, int math){
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }
        int getKor(){ return kor; }
        int getEng(){ return eng; }
        int getMath(){ return math; }
    }

    public static void main(String[] args) {
        matchingTest();
    }

    public static void matchingTest(){

        int[] array = {2, 4, 6, 8};

        //모든 요소가 짝수인가
        boolean result = Arrays.stream(array).allMatch(num -> num % 2 == 0);
        System.out.println(result);

        //최소 한개이상이 3의 배수인가
        result = Arrays.stream(array).anyMatch(num -> num % 3 == 0);
        System.out.println(result);

        //모든 요소가 3의 배수가 아닌가
        result = Arrays.stream(array).noneMatch(num -> num % 3 == 0);
        System.out.println(result);

    }

    public static void peekTest(){

        System.out.println(
                Arrays.asList(1, 2, 3, 4, 5).stream().peek(System.out::println)
                        .mapToInt(Integer::intValue).sum()
        );


    }

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

    public static void flatMapTest(){
        Arrays.asList(
                new Score( 40, 80, 23 ),
                new Score( 61, 88, 100 ),
                new Score( 94, 30, 77 )
        ).stream().flatMapToInt( score ->
            IntStream.of(
                    score.getKor(),
                    score.getEng(),
                    score.getMath())).average().ifPresent(avg ->
                            System.out.println(Math.round(avg * 10)/10.0));
    }

    public static void concatStream(){
        Stream<String> stream1 = Stream.of("Test", "Velog", "Groovy");
        Stream<String> stream2 = Stream.of("Java", "Javascript", "Kotlin");
        Stream<String> concat = Stream.concat(stream1, stream2);
        concat.forEach(System.out::println);
        //[ "Test", "Velog", "Groovy", "Java", "Javascript", "Kotlin" ]
    }

    public static void regExStreamTest(){
        //정규표현식 [ Test, Velog, Java ]
        Stream<String> stringStream = Pattern.compile(", ").splitAsStream("Test, Velog, Java");
    }
}
