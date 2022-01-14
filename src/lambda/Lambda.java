package lambda;

import java.util.function.*;

public class Lambda {


    public static void test(){
        /**
         * Consumer
         */
        Consumer<String> objConsumer = (obj) -> { System.out.println(obj); };
        BiConsumer biConsumer = (obj1, obj2) -> {
            System.out.println(obj1);
            System.out.println(obj2);
        };
        IntConsumer intConsumer = (t) -> { System.out.println(t); };
        LongConsumer longConsumer = (t) -> { System.out.println(t); };
        DoubleConsumer doubleConsumer = (t) -> { System.out.println(t); };
        ObjIntConsumer objIntConsumer = (obj, t) -> {
            System.out.println(obj);
            System.out.println(t);
        };
        ObjLongConsumer objLongConsumer = (obj, t) -> {
            System.out.println(obj);
            System.out.println(t);
        };
        ObjDoubleConsumer objDoubleConsumer = (obj, t) -> {
            System.out.println(obj);
            System.out.println(t);
        };

        class Address{
            String address;
            String city;
            String tel;
            Address(String address, String city, String tel){
                this.address = address;
                this.tel= tel;
            }
            String getCity(){
                return city;
            }
        }
        /**
         * Function
         */
        Function<Address, String> city = Address::getCity;
        //BiFunction<Address, String, Integer>


    }


}
