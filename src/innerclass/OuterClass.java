package innerclass;

import lambda.CustomFunctionalInterface;
import lombok.Builder;
import lombok.ToString;

public class OuterClass {

    private String outer1;

    @Builder
    @ToString
    static class User{
        /***
         * 내부 클래스와 비슷하지만, static으로 정적 선언을 한다.
         * 내부 클래스는 외부 클래스의 자원을 자유롭게 사용할 수 있지만,
         * static 중첩 클래스는 static 키워드가 붙지 않은 경우 사용할 수 없다.
         * Outer 클래스의 객체가 없어도 Inner Class의 객체 생성이 가능하다.
         */
        public String name;

        public String mail;
    }

    class InnerClass{
        /**
         * 내부 클래스의 장점
          * 내부 클래스에서 외부 클래스의 멤버들을 쉽게 접근할 수 있다.
         * 코드의 복잡성을 줄일 수 있다.
         * 클래스 내부에서만 사용되는 클래스를 위해 클래스 파일들을 늘리면 클래스 파일도 많아지고 번거롭다.
         * 내부에서만 사용하는 클래스의 경우는 내부 클래스로 선언하여 클래스 파일도 줄이고 간편하게 사용가능하다.
         */
        public void test(){
            System.out.println(outer1);
            System.out.println("내부 클래스 호출입니다.");
        }

    }

    public void method(final User user){
        /**
         * 로컬 클래스
         * 메소드 안에 선언된 클래스로 메소드 파라미터 및 지역 변수에 자유롭게 접근 가능하다.
         * 로컬 클래스 안에서 사용될 변수는 final로 선언되어야 한다.
         * 단일 메소드 안에서만 사용되는 클래스의 경우 사용한다.
         */
        class LocalClass{
            public void localClassTest(){
                System.out.println("로컬 클래스" + user.toString());
            }
        }
        new LocalClass().localClassTest();

        /**
         * 익명 내부 클래스
         * 익명 내부 클래스의 경우는 타입이나 이름이 없기 때문에
         * 상속이나 구현을 할 때 인터페이스나 추상 클래스의 타입으로
         * 선언하여 사용한다.
         *
         * 람다식으로 아래와 같이 표현할 수 있다.
         * TestInterface testInterface = () -> System.out.println("내부 익명 클래스" + user.toString());
         */
        TestInterface testInterface = new TestInterface(){
            @Override
            public void implementsMethod() {
                System.out.println("내부 익명 클래스" + user.toString());
            }
        };
        testInterface.implementsMethod();
    }

    public interface TestInterface{
        void implementsMethod();
    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        outerClass.outer1 = "외부 클래스 변수1";
        //내부 클래스
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        innerClass.test();

        User user = new User.UserBuilder().name("test").mail("naver.com").build();
        outerClass.method(user);

        User user2 = User.builder().name("test2").mail("google.com").build();
        outerClass.method(user2);
    }

}
