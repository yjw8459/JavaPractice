package designpattern.strategy;

public class Main {

    public static void main(String[] args) {
        Worker staff = new Worker.WorkerBuilder().name("staff").salary(3000).build();
        Worker manager = new Worker.WorkerBuilder().name("manager").salary(4500).build();
        Worker director = new Worker.WorkerBuilder().name("director").salary(6000).build();

        Calculator staffCalculator = new Calculator(new StaffStrategy());
        Calculator managerCalculator = new Calculator(new ManagerStrategy());
        Calculator directorCalculator = new Calculator(new DirectorStrategy());

        staff.builder().salary(staffCalculator.calculate(staff.getSalary())).build();
        manager.builder().salary(managerCalculator.calculate(manager.getSalary())).build();
        director.builder().salary(directorCalculator.calculate(director.getSalary())).build();

        System.out.println(staff.getSalary());
        System.out.println(director.getSalary());
        System.out.println(manager.getSalary());
    }
}
