package designpattern.strategy;

public class Main {

    public static void main(String[] args) {

        Calculator staffCalculator = new Calculator(new StaffStrategy());
        Calculator managerCalculator = new Calculator(new ManagerStrategy());
        Calculator directorCalculator = new Calculator(new DirectorStrategy());

        Worker staff = new Worker.WorkerBuilder()
                .name("staff")
                .salary(staffCalculator.calculate(3000))
                .build();
        Worker manager = new Worker.WorkerBuilder()
                .name("manager")
                .salary(managerCalculator.calculate(4500))
                .build();
        Worker director = new Worker.WorkerBuilder()
                .name("director")
                .salary(directorCalculator.calculate(6000))
                .build();

        System.out.println(staff.toString());
        System.out.println(manager.toString());
        System.out.println(director.toString());
    }
}
