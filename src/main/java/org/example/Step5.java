package org.example;

@FunctionalInterface
interface MyFunction<T, U, R> {
    R apply(T t, U u);
}

public class Step5 {
    public static void main(String[] args) {
        // 람다식 정의
        MyFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;

        // 람다식 호출
        int result = sum.apply(5, 3);

        // 결과 출력
        System.out.println(result);
    }
}