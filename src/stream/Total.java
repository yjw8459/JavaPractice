package stream;

import jdk.nashorn.internal.objects.annotations.Getter;
import vo.Dummy;
import vo.Student;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 집계
 */
public class Total {

    public static void main(String[] args) {
        reduce();
    }

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

    public static void filter(){
        Arrays.asList(new String[]{"test", "velog", "Hello", "velog"}).stream().filter(s -> "velog".equals(s)).forEach(System.out::println);
        System.out.println("================================================");
        Arrays.asList(new String[]{"test", "velog", "Hello", "velog"}).stream().distinct().forEach(System.out::println);
    }


    public static void pipelines(){

        Double scoreAvg = Dummy.getStudentList().stream().filter(s -> s.getSex() == Student.SEX.MALE)
                .mapToInt(Student::getScore).average().getAsDouble();

    }

    public static void forEachTest(){

        Arrays.asList(new String[]{"test", "velog", "Hello", "velog"}).forEach(System.out::println);

        Arrays.asList(new String[]{"test", "velog", "Hello", "velog"}).forEach(s -> {
            //멀티라인 일 경우
            System.out.println(s);
            System.out.println(s.length());
        });

    }


    /**
     * 집계 함수
     */
    public void totalFunction(){

        //sum, count는 정수 타입 반환
        long sum = Arrays.stream( new int[] {1, 2, 3, 4, 5, 6} ).filter(n -> n % 2 == 0).sum();
        long count = Arrays.stream( new int[] {1, 2, 3, 4, 5, 6} ).filter(n -> n % 2 == 0).count();


        /**
         * optional 객체 반환
         */

        //OptionalDouble
        double avg = Arrays.stream( new int[] {1, 2, 3, 4, 5, 6} ).filter(n -> n % 2 == 0).average().getAsDouble();

        //OptionalInt 반환
        long max = Arrays.stream( new int[] {1, 2, 3, 4, 5, 6} ).filter(n -> n % 2 == 0).max().getAsInt();
        long min = Arrays.stream( new int[] {1, 2, 3, 4, 5, 6} ).filter(n -> n % 2 == 0).min().getAsInt();
        int first = Arrays.stream( new int[] {1, 2, 3, 4, 5, 6} ).filter(n -> n % 2 == 0).findFirst().getAsInt();

    }

    /**
     * optional
     */
    public static void optional(){

        List<Integer> list = new ArrayList<>();

        /**
         * 방법 1 : optional 값이 없을 시 if문을 통해서 예외처리
         * mapToXXX 는 Stream 객체 반환
         */
        OptionalDouble optional = list.stream().mapToInt(Integer::intValue).average();
        if ( optional.isPresent() ) System.out.println(optional.getAsDouble());
        else                        System.out.println("0.0");

        /**
         * 방법 2: orElse를 통해서 값이 없을 경우 0.0으로 계산하도록 예외처리
         */
        System.out.println(list.stream().mapToInt(Integer::intValue).average().orElse(0.0));

        /**
         * 방법 3 : ifPresent를 통해서 값이 있을 경우만 계산하도록 예외처리
         */
        list.stream().mapToInt(Integer::intValue).average().ifPresent(a -> System.out.println(a));

    }

    public static void reduce(){
        List<Student> list = Arrays.asList(
                new Student("홍길동", 92, Student.SEX.MALE),
                new Student("유종원", 95, Student.SEX.MALE),
                new Student("자바김", 88, Student.SEX.MALE)
        );
        int sum1 = list.stream().mapToInt(Student::getScore).sum();

        //reduce에 디폴트 값이 없을 경우는 OptionalXXX 클래스를 반환하고, 디폴트 값이 있을경우 래퍼 클래스 반환
        int sum2 = list.stream().map(Student::getScore).reduce((a, b) -> a + b).get();      //디폴트 있을 경우 .get()
//        Integer reduce = list.stream().map(Student::getScore).reduce(0, (a, b) -> a + b);         디폴트 있음
//        Optional<Integer> reduce = list.stream().map(Student::getScore).reduce((a, b) -> a + b);  디폴트 없음
        int sum3 = list.stream().map(Student::getScore).reduce(0, (a, b) -> a + b); //디폴트 없을 경우 .get() X



    }

    public static void test(){

        int sum1 = Arrays.asList(1, 2, 3).stream().reduce((a, b) -> a + b).get();
        int sum2 = Arrays.asList(1, 2, 3).stream().reduce(0, (a, b) -> a + b);

    }

    public void collect(){
        List<Student> list = Arrays.asList(
                new Student("홍길동", 92, Student.SEX.MALE),
                new Student("유종원", 95, Student.SEX.MALE),
                new Student("자바김", 88, Student.SEX.FEMAIL),
                new Student("박수미", 70, Student.SEX.FEMAIL)
        );

        //둘의 차이점 Collectors(수집가)의 정의가 다름
        List<Student> maleList = list.stream().filter(s ->  s.getSex() == Student.SEX.MALE)
                .collect(Collectors.toList());

        Set<Student> femaleList = list.stream().filter( s -> s.getSex() == Student.SEX.FEMAIL )
                .collect(Collectors.toCollection(HashSet::new));



    }


}
