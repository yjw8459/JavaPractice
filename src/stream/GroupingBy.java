package stream;

import vo.Dummy;
import vo.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingBy {

    public void groupingBySex(){
        List<Student> totalList = Dummy.getStudentList();

        /**
         * Collectors.groupingBy : collect 메소드 안에 선언, 인자로 그룹 기준 값을 전달
         */
        Map<Student.SEX, List<Student>> groupBySex = totalList.stream()
                .collect(Collectors.groupingBy(Student::getSex));

        System.out.println("남학생");
        groupBySex.get(Student.SEX.MALE).stream().forEach(System.out::println);

        System.out.println("여학생");
        groupBySex.get(Student.SEX.FEMAIL).stream().forEach(System.out::println);

        //거주지 별 학생 클래스 분류
        Map<Student.CITY, List<Student>> groupByCity = totalList.stream()
                .collect(Collectors.groupingBy(Student::getCity));

        /**
         * 거주지 별 학생이름만 분류
         * Student::getName : Function<T, k> T는 Type, K는 key를 의미
         */
        Map<Student.CITY, List<String>> mapByCity = totalList.stream().collect(
                Collectors.groupingBy(
                        Student::getCity,   //키 값 지정
                        Collectors.mapping(
                                Student::getName,   //매핑을 Student.Name으로 한다.
                                Collectors.toList() //매핑한 값을 List로 수집한다.
                        ) //일부 데이터만 사용할 경우
                )
        );

        System.out.println("서울");
        mapByCity.get(Student.CITY.SEOUL).stream().forEach(System.out::println);
        System.out.println("부산");
        mapByCity.get(Student.CITY.BUSAN).stream().forEach(System.out::println);
    }
}
