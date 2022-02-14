package designpattern.strategy;

public class Calculator {

    private final Strategy strategy;

    public Calculator(Strategy strategy) {
        this.strategy = strategy;
    }

    public int calculate(int salary){
        return strategy.salaryIncreaser(salary);
    }
}
