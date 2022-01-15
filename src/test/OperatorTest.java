package test;

import java.util.function.IntBinaryOperator;

public class OperatorTest {

    static void test(){

        //IntBinaryOperator를 이용하여 최대 값 연산
        IntBinaryOperator maxOperator = (a, b) -> {
          if ( a >= b ) return a;
          else  return b;
        };

        //IntBinaryOperator를 이용하여 최소 값 연산
        IntBinaryOperator minOperator = (a, b) -> {
            if ( a <= b ) return a;
            else  return b;
        };

        int[] scores = { 99, 88, 77 };
        int max = scores[0];
        int min = scores[0];

        for (int score : scores){
            max = maxOperator.applyAsInt(max, score);
            min = minOperator.applyAsInt(min, score);
        }
        System.out.println("최대 값 : " + max + " 최소 값 : " + min);
    }

    public static void main(String[] args) {
        test();
    }

}
