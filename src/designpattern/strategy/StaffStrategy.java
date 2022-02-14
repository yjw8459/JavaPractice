package designpattern.strategy;

public class StaffStrategy implements Strategy{
    @Override
    public int salaryIncreaser(int salary) {
        return salary + 200;
    }
}
