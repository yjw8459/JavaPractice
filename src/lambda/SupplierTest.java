package lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class SupplierTest {

    public static void test(){

        //IntSupplier
        IntSupplier intSupplier = () -> (int) (Math.random() * 6) + 1;
        int num = intSupplier.getAsInt();

        //Supplier<T>
        Supplier<Map<String, String>> getAsMap = HashMap::new;
        Map<String, String> map = getAsMap.get();

    }

}
