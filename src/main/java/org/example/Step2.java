package org.example;

// 함수형 인터페이스 정의
interface MyFunction1 {
    int sum(int a, int b);
}

public class Step2 implements MyFunction1 {
    // implements 인터페이스 구현
    @Override
    public int sum(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        Step2 s2 = new Step2();

        // 익명 클래스 메서드 호출
        int result = s2.sum(5, 3);

        // 결과 출력
        System.out.println(result);
    }
}