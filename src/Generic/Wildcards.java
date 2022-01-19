package Generic;

import vo.Student;

import java.util.Arrays;

public class Wildcards {

    public class Course<T>{
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

    public void registerCourse( Course<?> course ) {
        System.out.println(course.getName() + " 수강생");
        Arrays.toString(course.getStudents());
    }

    public void registerCourseStudent(Course<? extends Student> course){
        System.out.println(course.getName() + "수강생");
        Arrays.toString(course.getStudents());
    }

    public void registerCourseWorker( Course<? super Worker> course ){
        System.out.println(course.getName() + " 수강생");
        Arrays.toString(course.getStudents());
    }

    public static void main(String[] args) {
        //Course<Person> personCourse = new Course<Person>("일반인 과정", 5);

    }
}
