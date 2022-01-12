package stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class Reducer {

    public static void reduceTest(){

        Integer reducedParams = Stream.of(1, 2, 3).reduce(10, Integer::sum, (a, b) -> {
            System.out.println("combiner was called");
            return a + b;
        });
        System.out.println(reducedParams); // 출력 : 16

        /**
         * 병렬처리의 경우 배열을 3개의 서브 쓰레드로 나눠서 작업한다.
         * 이 때 초기 값 10도 3개 생성되고, 10 + 1 , 10 + 2, 10 + 3 으로 계산된 후
         * combined를 호출한다. combined : (1 + 2) => (1,2) + 3
         */
        Integer reducedParallel = Arrays.asList(1, 2, 3).parallelStream().reduce(10, Integer::sum,(a, b) -> {
            System.out.println("combiner was called");
            return a + b;
        });
        System.out.println(reducedParallel); // 출력 : 36
    }

    public static void main(String[] args) {
        reduceTest();
    }
}
