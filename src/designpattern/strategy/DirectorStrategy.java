package designpattern.strategy;

public class DirectorStrategy implements Strategy{
    @Override
    public int salaryIncreaser(int salary) {
        return salary + 400;
    }
}
