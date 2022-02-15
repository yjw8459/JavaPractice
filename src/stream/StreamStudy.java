package stream;

import vo.Dummy;
import vo.Student;

import java.util.List;
import java.util.stream.Stream;

/**
 * https://futurecreator.github.io/2018/08/26/java-8-streams/
 */
public class StreamStudy {

    //파이프라인
    public static void pipelines(){

        Double scoreAvg = Dummy.getStudentList().stream().filter(s -> s.getSex() == Student.SEX.MALE)
                .mapToInt(Student::getScore).average().getAsDouble();

    }

    //비어있는 스트림 체크
    public static Stream<String> emptyCheck(List<String> list){
        return list == null || list.isEmpty()
                ? Stream.empty() : list.stream();
    }

    /**
     * generate 메서드로 Supplier<T>에 해당하는 람다로 값을 넣을 수 있다.
     * Supplier<T> : 인자는 없고 리턴 값만 있는 함수형 인터페이스
     * public static<T> Stream<T> generate(Supplier<T> s) { ... }
     */
    public static void generateTest(){
        //[ "yjw", "yjw", "yjw", "yjw", "yjw"]
        Stream<String> generatedStream = Stream.generate( () -> "yjw" ).limit(5);
    }

    public static void builderTest(){
        //Builder를 사용하면 스트림에 직접적으로 원하는 값을 넣을 수 있다. build메서드로 스트림 리턴
        Stream<String> builderStream = Stream.<String>builder().add("test").add("PEG").add("intelliJ").build();
    }

    //iterate 메서드를 이용하면 초기 값과 해당 값을 다루는 람다를 이용해서 스트림에 들어갈 요소들을 반복하여 만듬
    public static void iterateTest(){
        //[ 30, 32, 34, 36, 38 ]
        Stream<Integer> iteratedStream = Stream.iterate(30, n -> n + 2).limit(5);
    }

}
