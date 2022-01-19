package Generic;

import com.sun.corba.se.spi.orbutil.threadpool.Work;
import vo.Student;

import java.util.Arrays;

public class Wildcards {

    public static class Person{
        private String type;
        Person(String type){
            this.type = type;
        }
    }

    public static class Worker extends Person{
        Worker(String type){
            super(type);
        }
    }

    public static class Student extends Person{
        Student(String type){
            super(type);
        }
    }

    public static class HighStudent extends Student{
        HighStudent(String type){
            super(type);
        }
    }


    public static class Course<T>{
        private String name;
        private T[] students;

        public Course(String name, int capacity){
            this.name = name;
            students = (T[]) (new Object[capacity]);
        }
        public String getName(){ return name; }
        public T[] getStudents() { return students; }

        public void add(T t){
            for (int i = 0; i < students.length; i++){
                if ( students[i] == null ){
                    students[i] = t;
                    break;
                }
            }
        }
    }

    public static void registerCourse( Course<?> course ) {
        System.out.println(course.getName() + " 수강생");
        Arrays.toString(course.getStudents());
    }

    public static void registerCourseStudent(Course<? extends Student> course){
        System.out.println(course.getName() + "수강생");
        Arrays.toString(course.getStudents());
    }

    public static void registerCourseWorker( Course<? super Worker> course ){
        System.out.println(course.getName() + " 수강생");
        Arrays.toString(course.getStudents());
    }

    public static void main(String[] args) {

        Course<Person> personCourse = new Course<Person>("일반인 과정", 5);
        personCourse.add(new Person("일반인"));
        personCourse.add(new Person("직장인"));
        personCourse.add(new Student("학생"));
        personCourse.add(new HighStudent("고등학생"));

        Course<Worker> workerCourse = new Course<>("직장인과정", 5);
        workerCourse.add(new Worker("직장인"));

        Course<Student> studentCourse = new Course<>("학생과정", 5);
        studentCourse.add(new Student("학생"));
        studentCourse.add(new HighStudent("고등학생"));

        Course<HighStudent> highStudentCourse = new Course<>("고등학생", 5);
        highStudentCourse.add(new HighStudent("고등학생"));

        registerCourse(personCourse);
        registerCourse(workerCourse);
        registerCourse(studentCourse);
        registerCourse(highStudentCourse);
        System.out.println();

        //registerCourseStudent(personCourse);  X
        //registerCourseStudent(workerCourse);  X
        registerCourseStudent(studentCourse);
        registerCourseStudent(highStudentCourse);
        System.out.println();

        registerCourseWorker(personCourse);
        registerCourseWorker(workerCourse);
        //registerCourseWorker(studentCourse);      X
        //registerCourseWorker(highStudentCourse);  X
    }
}
