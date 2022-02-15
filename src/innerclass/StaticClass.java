package innerclass;

public class StaticClass {
    public void test(){
        //외부에서 내부 static 중첩 클래스 선언
        OuterClass.User user = new OuterClass.User.UserBuilder().name("test2").mail("google.com").build();
    }
}
