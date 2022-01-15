package test;

import java.awt.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Test {

    public static void test(){

        Function<Integer, String> test = String::valueOf;

        //함수몸체가 단일 행이면 {}생략, 함수몸체가 return문 하나로만 구성되어 있을 경우 return 생략
        BiFunction<Integer, Integer, Integer> biFunction = (x, y) -> x + y;

        //매개 값과 리턴 값이 없을 경우
        Runnable runnable = () -> { };

        //매개 변수가 하나일 경우 () 생략
        Function<String, String> function = str -> str + "!!!";

        //매개 변수가 두개 이상일 경우 ()
        BiFunction<String, String, String> binaryFunction = (str1, str2) -> str1 + str2;



        CustomFunctionalInterface customFunctionalInterface = (a, b) -> a + b;



    }

}
