package vo;

import java.util.Arrays;
import java.util.List;

public class Dummy {

    private static List<Student> studentList;

    public static List<Student> getStudentList() {
        studentList = Arrays.asList(
                new Student("유종원", 93, Student.SEX.MALE, Student.CITY.SEOUL),
                new Student("손오공", 60, Student.SEX.MALE, Student.CITY.BUSAN),
                new Student("피콜로", 83, Student.SEX.MALE, Student.CITY.SEOUL),
                new Student("나루토", 77, Student.SEX.MALE, Student.CITY.BUSAN),
                new Student("천소영", 99, Student.SEX.FEMAIL, Student.CITY.SEOUL),
                new Student("사쿠라", 52, Student.SEX.FEMAIL, Student.CITY.BUSAN),
                new Student("미란이", 74, Student.SEX.FEMAIL, Student.CITY.SEOUL),
                new Student("뽀로로", 21, Student.SEX.FEMAIL, Student.CITY.BUSAN)

        );
        return studentList;
    }
}
