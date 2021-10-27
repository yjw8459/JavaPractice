import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("test","test1");
        System.out.println(list.toString());
        list.stream().forEach(str -> str = "ttt");
        System.out.println(list.toString());

        IntStream intStream = Stream.iterate(0, n -> n+2).limit(3);
    }
}
