package stream;

import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * 기본 타입형 스트림
 */
public class PrimitiveStream {

    public static void PrimitiveStreamTest(){
        IntStream intStream = IntStream.range(1, 5);
        LongStream longStream = LongStream.rangeClosed(1, 5);
        Stream<Integer> boxed = IntStream.range(1, 5).boxed();
        DoubleStream doubles = new Random().doubles(3); //난수 3개 생성
    }



}
