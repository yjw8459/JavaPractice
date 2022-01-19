package Generic;

import lambda.Test;

import javax.rmi.CORBA.Util;
import java.util.ArrayList;
import java.util.List;

public class GenericTest {

    static class TestParent{
        public static void printParent(){
            System.out.println("Parent 출력");
        }
    }

    static class Test extends TestParent{
        public static void printChild(){
            System.out.println("Child 출력");
        }
    }

    public static <T extends TestParent> void genericTest(T t){
        t.printParent();
        //t.printChild();
    }

    public static void main(String[] args) {
        genericMethod(new Test());
    }

    static class Test1 <T> extends TestParent {
        private T type;


        T getType(){ return type; }
        Test1(T type){
            this.type = type;
        }
    }

    static class Test1Child <T> extends Test1<T>{

        Test1Child(T type) {
            super(type);
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

    public static void test2(){

        List list = new ArrayList();
        list.add("velog");
        String str = (String) list.get(0);

    }

    static class MultiType <T, K> {
        private T type;
        private K key;
        public T getType(){ return type; }
        public K getKey(){ return key; }
        public void setType( T type ){ this.type = type; }
        public void setKey( K key ) { this.key = key; }
    }

    public static void multiType(){
        MultiType<String, Integer> test1 = new MultiType<>();
        test1.setType("velog");
        test1.setKey(10000);
        String type1 = test1.getType();
        Integer key1 = test1.getKey();

        MultiType<Object, Double> test2 = new MultiType<>();
        test2.setType(new Object());
        test2.setKey(1000.0);
        Object type2 = test2.getType();
        Double key2 = test2.getKey();
    }

    static class Box<T>{
        private T box;
        public T getBox(){ return box; }
        public void setBox(T box){ this.box = box; }
    }

    static class GenericMethod{
        public static <T> Box<T> boxing(T t){
            Box<T> box = new Box<T>();
            box.setBox(t);
            return box;
        }
    }

    public static <T> void genericMethod(T t){
        Box<Integer> box1 = GenericMethod.<Integer>boxing(100);
        int intValue = box1.getBox();

        Box<String> box2 = GenericMethod.boxing("velog");
        String strValue = box2.getBox();
    }



}
