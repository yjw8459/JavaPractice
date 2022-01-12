package stream;

import java.util.Arrays;

public class Matching {

    public static void matchingTest(){

        int[] array = {2, 4, 6, 8};

        //모든 요소가 짝수인가
        boolean result = Arrays.stream(array).allMatch(num -> num % 2 == 0);
        System.out.println(result);

        //최소 한개이상이 3의 배수인가
        result = Arrays.stream(array).anyMatch(num -> num % 3 == 0);
        System.out.println(result);

        //모든 요소가 3의 배수가 아닌가
        result = Arrays.stream(array).noneMatch(num -> num % 3 == 0);
        System.out.println(result);

    }

}
