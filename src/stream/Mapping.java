package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Mapping {

    static class Cat{
        String name;
        int age;
        Cat(String name, int age){
            this.name = name;
            this.age = age;
        }
        public int getAge(){
            return age;
        }
    }

    public static void map(){
        List<Cat> cats = Arrays.asList(
                new Cat("coco", 3),
                new Cat("choco", 2)
        );
        cats.stream().mapToInt(Cat::getAge).forEach(System.out::println);
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

}
