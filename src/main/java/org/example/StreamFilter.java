package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamFilter {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "ABob", "Charlie", "ADave");

        names.stream()
                .filter(name -> name.startsWith("A"))
                .forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        numbers.stream()
                .map(number -> number * 2)
                .forEach(System.out::println);

        List<String> fruits = Arrays.asList("Banana", "Apple", "Mango", "Apricot");

        fruits.stream()
                .sorted()
                .forEach(System.out::println);

        Stream.of("Apple", "Banana", "Mango", "apple")
//                .distinct()
//                .limit(2)
                .skip(2)
                .forEach(System.out::println);

        Stream<String> stream = Stream.of("A", "B", "C", "D", "E");
//        String[] str = new String[3];
//        System.out.println(str.length);

//        List<String> list = new ArrayList<String>();
//        System.out.println(list.size());
        System.out.println(stream.count());
        //long count = stream.count();
        //System.out.println(count);

        Stream<String> names1 = Stream.of("Alice", "Bob", "Charlie", "Dave");
        boolean anyMatch = names1.anyMatch(name -> name.startsWith("A"));
        System.out.println(anyMatch);

        Stream<Integer> numbers2 = Stream.of(5, 3, 8, 3, 1);

        Integer max = numbers2.max(Comparator.naturalOrder()).orElse(-1);
        System.out.println(max); // 최대값 요소 찾기

        numbers2 = Stream.of(5, 3, 8, 3, 1); // 스트림 재생성
        Integer min = numbers2.min(Comparator.naturalOrder()).orElse(-1);
        System.out.println(min); // 최소값 요소 찾기

        Stream<Integer> numbers3 = Stream.of(1, 2, 3, 4, 5, 6);
        Integer sum = numbers3.reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        StreamFilter streamFilter = new StreamFilter();
        streamFilter.sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    public void sum(int... a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        System.out.println(sum);
    }
}
