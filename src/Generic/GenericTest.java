package Generic;

import lambda.Test;

public class GenericTest {

    static class TestParent{

    }

    static class Test1 <T> extends TestParent {
        private T type;


        T getType(){ return type; }
        Test1(T type){
            this.type = type;
        }
    }

    static class Test2 <T> extends TestParent{
        private T type;

        T getType() { return type; }

        Test2(T type){
            this.type = type;
        }
    }

    static class Test3 <T, K>{
        private T type1;
        private K type2;

        Test3(T type11, K type2){
            this.type1 = type11;
            this.type2 = type2;
        }
    }

    static class Test4{

        static void print(Test1<? extends Object> arg1){
            System.out.println(arg1.getType());
        }

    }

    public static void test(){
        Test1<String> test1 = new Test1<>("String");
        Test2<Integer> test2 = new Test2<>(1);

        new Test3<String, Integer>("String", 1);
        Test4.print(test1);
    }

    public static void main(String[] args) {
        test();
    }

}
