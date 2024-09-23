package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectExample {
    public static void main(String[] args) {
        Stream<String> fruitStream = Stream.of("Apple", "Banana", "Cherry", "Date", "Date");
        List<String> fruitList = fruitStream.collect(Collectors.toList()); // List
        System.out.println(fruitList);

        fruitStream = Stream.of("Apple", "Banana", "Cherry", "Date", "Date");
        Set<String> set = fruitStream.collect(Collectors.toSet()); // Set
        System.out.println(set);

        fruitStream = Stream.of("Apple", "Banana", "Cherry", "Date", "Date");
        String str = fruitStream.collect(Collectors.joining()); // 문자열 조인
        System.out.println(str);

        fruitStream = Stream.of("Apple", "Banana", "Cherry", "Date");
        Map<String, Integer> fruitMap = fruitStream.collect(Collectors.toMap(fruit -> fruit, fruit -> fruit.length())); // Map
        System.out.println(fruitMap);

        // 연산 체이닝:문자열 처리
        List<String> words = Arrays.asList("Stream", "Operations", "Java", "Lambda", "Filter", "Collect");

        List<String> result = words.stream()
                .filter(word -> word.length() > 5)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(result);

        for (String str1 : result) {
            System.out.println(str1);
        }
    }
}
