package stream;

import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StreamUtil {

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
