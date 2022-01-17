package lambda;

import java.util.function.*;

public class ConsumerTest {

    public static void test(){

        //String T를 받아 소비
        Consumer<String> consumer = t -> System.out.println(t);

        //String T와 Integer U를 받아 소비
        BiConsumer<String, Integer> biConsumer = (str, num) -> System.out.println(str + num);

        //double 값을 받아 소비
        DoubleConsumer doubleConsumer = doubleValue -> System.out.println(doubleValue);

        //IntConsumer, LongConsumer ......

        ObjIntConsumer<String> objIntConsumer = (str, num) -> System.out.println(str + num);

        //ObjLongConsumer, ObjDoubleConsumer ......


    }

}
