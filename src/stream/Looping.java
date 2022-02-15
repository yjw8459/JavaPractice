package stream;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * peek과 forEach의 차이점
 *  peek의 경우는 중간처리 반복
 *  forEach는 최종처리 반복
 */
public class Looping {

    public static void peekTest(){

        System.out.println(
                Arrays.asList(1, 2, 3, 4, 5).stream().peek(System.out::println)
                        .mapToInt(Integer::intValue).sum()
        );


    }

    public static void forEachTest(){

        Arrays.asList(new String[]{"test", "velog", "Hello", "velog"}).forEach(System.out::println);
        Arrays.asList(new String[]{"test", "velog", "Hello", "velog"}).forEach(s -> {
            //멀티라인 일 경우
            System.out.println(s);
            System.out.println(s.length());
        });
    }

    public static void main(String[] args) {
        peekTest();
    }
}
