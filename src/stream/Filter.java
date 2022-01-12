package stream;

import java.util.Arrays;

public class Filter {

    public static void filter(){
        Arrays.asList(new String[]{"test", "velog", "Hello", "velog"}).stream().filter(s -> "velog".equals(s)).forEach(System.out::println);
        System.out.println("================================================");
        Arrays.asList(new String[]{"test", "velog", "Hello", "velog"}).stream().distinct().forEach(System.out::println);
    }

}
