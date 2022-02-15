package lambda.refrence;

public class TestService {

    public static String test(Test test, String str1, String str2){
        return test.test(str1, str2);
    }


    public static void main(String[] args) {
        test((str1, str2) -> str1 + str2, "A", "B");
        System.out.println(test((str1, str2) -> str1 + str2, "A", "B"));
    }

}
