package lambda;

import java.util.function.Function;
import java.util.function.ToIntFunction;

public class FunctionTest {

    public static void test(){

        //객체 T를 R로 매핑 : String -> Integer
        Function<String, Integer> function = str -> Integer.parseInt(str);

        //객체 T를 int로 매핑 : String -> int
        ToIntFunction<String> toIntFunction = str -> Integer.parseInt(str);


    }

}
