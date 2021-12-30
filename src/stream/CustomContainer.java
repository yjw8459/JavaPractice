package stream;

import vo.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomContainer {

    private List<Student> list;

    public List<Student> getList() {
        return list;
    }

    public CustomContainer() {
        list = new ArrayList<>();
        //쓰레드 생성 시 로그
        System.out.println("쓰레드 생성 : " + Thread.currentThread().getName());
    }

    public void accumulate(Student student){
        list.add(student);
        printLog("accumulate");
    }

    public void combine(CustomContainer other){
        list.addAll(other.getList());
        printLog("combine");
    }

    public void printLog(String methodName){
        System.out.println(Thread.currentThread().getName() + "_" + methodName);
    }

    public void collect1(){
        List<Student> totalList = Arrays.asList(
            new Student("유종원", 10, Student.SEX.MALE),
            new Student("천소영", 6, Student.SEX.FEMAIL),
            new Student("송중기", 10, Student.SEX.MALE),
            new Student("송혜교", 6, Student.SEX.FEMAIL)
        );

        /**
         * 1. CustomContainer를 생성(보관) CustomContainer::new
         * 2. CustomContainer에 더함(수집) CustomContainer::accumulate
         * 3. CustomContainer에 합침(결합) CustomContainer::combine
         *
         * 정리 : totalList에서 남성에 해당하는 것만 CustomContainer를 생성해서 더해줌
         *       결합은 멀티 쓰레드일 때만 동작함. combine은 꼭 써줘야함.(Syntax Error)
         *
         */
        CustomContainer customContainer = totalList.stream()
                .filter(s -> s.getSex() == Student.SEX.MALE)
                .collect(CustomContainer::new, CustomContainer::accumulate, CustomContainer::combine);

        customContainer.getList().stream().forEach(System.out::println);
    }

    public void collect2(){
        List<String> test = Arrays.asList(
                "test", "dddd", "dsadadas"
        );
        List<String> test2 = test.stream().filter( s -> s.equals("dddd")).collect(Collectors.toList());
        test2.stream().forEach(System.out::println);
    }

    public static void main(String[] args) {
//        CustomContainer test = new CustomContainer();
//        test.test();
        new CustomContainer().collect1();
    }
}
