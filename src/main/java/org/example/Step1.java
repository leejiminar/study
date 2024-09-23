package org.example;

public class Step1 {
    // 일반 메서드 정의
    static int sum(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        // 일반 메서드 호출
        int result = sum(5, 3);

        // 결과 출력
        System.out.println(result);
    }
}