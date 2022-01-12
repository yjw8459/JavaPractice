package stream;

import vo.Dummy;
import vo.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class GroupingBy {

    public static void main(String[] args) {
        groupingByTest();
    }

    public static void groupingByTest(){

        //풀어쓰기
        List<Student> totalList = Dummy.getStudentList();
        Function<Student, String> name = Student::getName;  //Function 생성
        Function<Student, Student.SEX> sex = Student::getSex;

        Collector<Student, ?, List<String>> studentNameList = Collectors.mapping(name, Collectors.toList());
        Collector<Student, ?, Map<Student.SEX, List<String>>> collector = Collectors.groupingBy(sex, studentNameList);

        totalList.stream().collect(collector).forEach((sex1, strings) -> System.out.println(sex1+" " + strings));

        //줄여쓰기
        totalList = Dummy.getStudentList();
        totalList.stream().collect(Collectors.groupingBy(Student::getSex, Collectors.mapping(
                Student::getName,
                Collectors.toList()
        )));
    }

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
         *
         * Function<T, K> function = Student::getName();
         *  : T(Type)을 K(Key)로 반환하는 함수.
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

    /**
     * Collectors :
     *  Stream.collect() : 데이터의 중간 처리 후 마지막에 원하는 형태로 변환해 주는 역할을 한다.
     *                     List, Set, Map 자료형으로 변환
     *                          Collectors.toSet()
     *                          Collectors.toList()
     *                          Collectors.toMap()
     *                          Collectors.toCollection()
     *                     요소들의 통계 (최대, 최소, 평균 ...)
     *
     *                     요소들의 그룹화와 분할
     */
    public void groupingAndReduction(){
        List<Student> list = Dummy.getStudentList();
        //성별 별 평균점수 집계
        Map<Student.SEX, Double> groupBySex = list.stream().collect(Collectors.groupingBy(
                Student::getSex,
                Collectors.averagingDouble(Student::getScore)   //mapping, averagingDouble등 Collectors 반환 메소드
                //Collectors.summingLong(Student::getScore)
        ));
        System.out.println("남학생 평균 점수 : "  + groupBySex.get(Student.SEX.MALE));
        System.out.println("여학생 평균 점수 : "  + groupBySex.get(Student.SEX.FEMAIL));

        Map<Student.SEX, String> joiningName = list.stream().collect(Collectors.groupingBy(
                Student::getSex,
                Collectors.mapping(
                        Student::getName,
                        Collectors.joining(",")     //문자열 사이에 붙일 문자열
                )
        ));
    }
}
