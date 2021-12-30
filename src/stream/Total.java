package stream;

import vo.Student;

import java.util.*;
import java.util.stream.IntStream;

/**
 * 집계
 */
public class Total {

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
    public void optional(){
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
        double avg = list.stream().mapToInt(Integer::intValue).average().orElse(0.0);

        /**
         * 방법 3 : ifPresent를 통해서 값이 있을 경우만 계산하도록 예외처리
         */
        list.stream().mapToInt(Integer::intValue).average().ifPresent(a -> System.out.println(a));
    }

    public void reduce(){
        List<Student> list = Arrays.asList(
                new Student("홍길동", 92),
                new Student("유종원", 95),
                new Student("자바김", 88)
        );
        int sum1 = list.stream().mapToInt(Student::getScore).sum();

        //reduce에 디폴트 값이 없을 경우는 OptionalXXX 클래스를 반환하고, 디폴트 값이 있을경우 래퍼 클래스 반환
        int sum2 = list.stream().map(Student::getScore).reduce((a, b) -> a + b).get();      //디폴트 있을 경우 .get()
//        Integer reduce = list.stream().map(Student::getScore).reduce(0, (a, b) -> a + b);         디폴트 있음
//        Optional<Integer> reduce = list.stream().map(Student::getScore).reduce((a, b) -> a + b);  디폴트 없음
        int sum3 = list.stream().map(Student::getScore).reduce(0, (a, b) -> a + b); //디폴트 없을 경우 .get() X



    }

}
