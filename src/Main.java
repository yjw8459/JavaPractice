import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("test","test1");
        System.out.println(list.toString());
        list.stream().forEach(str -> str = "ttt");
        System.out.println(list.toString());
    }
}
