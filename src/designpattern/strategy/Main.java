package designpattern.strategy;

public class Main {

    public static void main(String[] args) {

        Calculator staffCalculator = new Calculator(new StaffStrategy());
        Calculator managerCalculator = new Calculator(new ManagerStrategy());
        Calculator directorCalculator = new Calculator(new DirectorStrategy());

        Worker staff = new Worker("staff", 3000);
        Worker manager = new Worker("manager", 4500);
        Worker director = new Worker("director", 6000);

        staff.setSalary(staffCalculator.calculate(staff.getSalary()));
        manager.setSalary(managerCalculator.calculate(manager.getSalary()));
        director.setSalary(directorCalculator.calculate(director.getSalary()));
    }
}
