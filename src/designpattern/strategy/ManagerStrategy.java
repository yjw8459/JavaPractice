package designpattern.strategy;

public class ManagerStrategy implements Strategy{
    @Override
    public int salaryIncreaser(int salary) {
        return salary + 300;
    }
}
