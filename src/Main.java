import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("test","test1");
        System.out.println(list.toString());
        list.stream().forEach(str -> str = "ttt");
        System.out.println(list.toString());
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> collect = intList.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
        System.out.println(collect.toString());


    }
}
