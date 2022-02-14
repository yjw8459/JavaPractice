package designpattern;

public abstract class Super {

    public void templateMethod(){
        hookMethod();
        abstractMethod();
    }

    protected void hookMethod() {
        System.out.println("공통 로직");
    }

    public abstract void abstractMethod();

}
