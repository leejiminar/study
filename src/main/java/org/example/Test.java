package org.example;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        List<String> t = new ArrayList<>();
        t.add("사과");
        t.add("바나나");
        t.add("체리");
        t.add("대추");

        for(int i=0; i<t.size(); i++){
            System.out.println(t.get(i));
        }

        // 컬렉션 요소 처리
        List<String> items = Arrays.asList("사과", "바나나", "체리", "대추");
        items.forEach(item -> System.out.println(item));

        // 스레드 생성
        new Thread(() -> System.out.println("새로운 스레드 실행")).start();

        // 컬렉션 필터링
        List<String> fruits = Arrays.asList("사과", "바나나", "체리", "대추");
        fruits.stream().filter(f -> f.startsWith("바")).forEach(System.out::println);

        // 이벤트 리스너
        JButton button = new JButton("클릭");
        button.addActionListener(e -> System.out.println("버튼이 클릭되었습니다."));

        // 람다 표현식
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.forEach(number -> System.out.println(number));

        // 메서드 참조
        numbers.forEach(System.out::println);

        // 람다 표현식
        List<String> strings = Arrays.asList("a", "b", "c");
        strings.forEach(s -> System.out.println(s.toUpperCase()));

        // 메서드 참조
        strings.stream().map(String::toUpperCase).forEach(System.out::println);

        // 람다 표현식
        Supplier<List<String>> supplier = () -> new ArrayList<>();
        System.out.println(supplier);

        // 메서드 참조
        Supplier<List<String>> supplier2 = ArrayList::new;
        System.out.println(supplier2);

        int cnt = 10000000; // 5, 10, 100, 1000, 10000, 100000, 1000000, 10000000,
        DecimalFormat formatter = new DecimalFormat("#,###");

        System.out.println("##### cnt: "+ cnt +" #####");

        long start = System.nanoTime();
        IntStream.range(0, cnt).forEach(e -> {   });
        long end = System.nanoTime();
        System.out.println("람다: " + formatter.format(end - start) + " n/s");

        start = System.nanoTime();
        for(int i=0; i<cnt; i++){   }
        end = System.nanoTime();
        System.out.println("일반: " + formatter.format(end - start) + " n/s");

        System.out.println();

        List<String> strings1 = Arrays.asList("Apple", "An", "Banana", "Orange", "Kiwi");

        List<String> filtered = strings1.stream()
                .filter(s -> s.length() > 3)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(filtered);

        List<String> strings2 = new ArrayList<>();
        strings2.add("Apple");
        strings2.add("An");
        strings2.add("Banana");
        strings2.add("Orange");
        strings2.add("Kiwi");

        List<String> filtered2 = new ArrayList<>();
        for(int i=0; i<strings2.size(); i++) {
            if(strings2.get(i).length() > 3) {
                filtered2.add(strings2.get(i).toUpperCase());
            }
        }
        System.out.println(filtered2);

        // 컬렉션에서 stream() 메소드 사용
        List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
        Stream<String> listStream = list.stream();

        String[] array = {"Dog", "Cat", "Elephant"};

        Stream<String> ofStream = Stream.of("Java", "Python", "C++");
        Stream<Integer> iterateStream = Stream.iterate(0, n -> n+2).limit(10);
        Stream<Double> generateStream = Stream.generate(Math::random).limit(10);

        System.out.println(list);
        System.out.println(listStream);
        System.out.println(array);
        System.out.println(Arrays.toString(ofStream.toArray()));
        System.out.println(Arrays.toString(iterateStream.toArray()));
        System.out.println(Arrays.toString(generateStream.toArray()));
    }
}