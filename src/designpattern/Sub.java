package designpattern;

public class Sub extends Super{

    @Override
    public void abstractMethod() {
        System.out.println("클래스 별로 다른 로직 구현");
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.templateMethod();
    }
}
