package stream;


import vo.Dummy;
import vo.Student;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * Java Collectors
 *
 *
 * Stream의 마지막 단계에서 사용된다.
 *
 * Stream.collect()
 * 데이터의 중간 처리 후 **마지막에 원하는 형태로 변환해주는 역할**
 * collector는 아래와 같은 기능을 제공한다.
 *
 * - stream 요소들을 List, Set, Map 자료형으로 변환
 * - stream 요소들의 결합(joining)
 * - stream 요소들의 통계(최대, 최소, 평균값 등)
 * - stream 요소들의 그룹화와 분할
 *
 * 변환, 결합, 통계, 분할
 *
 *
 * Collectors.toList();
 *
 * 모든 Stream의 요소를 List 인스턴스로 수집하는데 사용할 수 있다.
 * 해당 메서드는 특정한 List를 구현하는 것이 아니며 이것을 좀 더 잘 제어하려면,
 * toCollection를 대신 사용할 수 있다.
 *
 *
 * Collectors.toCollection()
 * toList, toSet은 특정 List, Set의 구현을 지정할 수 없다(ex. HashSet, TreeSet).
 * 특정 Collection을 구현하려면 Collectors.toCollection 사용
 * * 변경 불가능한 컬렉션에는 작동하지 않음.
 *
 * Collectors.toMap()
 * toMap Collector는 stream 요소를 Map 인스턴스로 수집하는 데 사용한다.
 * keyMapper
 * valueMapper
 * keyMapper는 Stream 요소에서 Map의 Key를 추출하는 데 사용
 * valueMapper는 지정된 키와 관련된 값을 추출하는데 사용
 *
 */
public class CollectorsStudy {

    public static void collectorsTest(){

        //List
        List<String> list = Dummy.getStudentList().stream().map(Student::getName).collect(toList());

        //Set›
        Set<String> set = Dummy.getStudentList().stream().map(Student::getName).collect(toSet());

        list.forEach(System.out::println);  //배열›
        set.forEach(System.out::println);   //집합
        //구체적인 Collection 선언

        //toCollection의 매개 인자 ArrayList를 LinkedList... 등으로 바꿀 수 있다.
        List<Student> lists = Dummy.getStudentList().stream().collect(toCollection(ArrayList::new));

        //toCollection의 매개 인자 HashSet을 TreeSet... 등으로 바꿀 수 있다.
        Set<Student> sets = Dummy.getStudentList().stream().collect(toCollection(HashSet::new));

        /**
         * 문자열을 key로하고 길이를 value로한다.
         * Function.identity()는 stream에 전달된 요소의 값을 그대로 반환
         * collection에 중복 요소가 포함되어 있다면 toSet과 다르게 toMap은 중복을 자동으로 필터링 하지않음.
         * 중복 키가 있으면 IllegalStateException 발생
         *
         */

        Map<String, Integer> result = Arrays.asList("velog", "java", "spring").stream()
                .collect(toMap(Function.identity(), String::length));

        /**
         * 충돌이 있을 경우를 생각하여 중복 시 item으로 사용할 것을 선언(두 충돌 값 중 하나만 선택할 것.)
         * collect의 3번째 인자는 BinaryOperator로 충돌 처리 방법을 지정할 수 있다.
         */
        Map<String, Integer> result2 = list.stream().collect(toMap(Function.identity(), String::length, (item, identicalItem) -> item));


    }
    public static void main(String[] args) {
        collectorsTest();
    }

}
