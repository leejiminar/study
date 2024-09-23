package org.example;
// 함수형 인터페이스 정의
interface MyFunction2 {
    int sum(int a, int b);
}

public class Step3 {
    public static void main(String[] args) {
        // 익명 객체(익명 클래스) 사용하여 함수형 인터페이스 구현
        MyFunction2 f = new MyFunction2() {
            @Override
            public int sum(int a, int b) {
                return a + b;
            }
        };

        // 익명 클래스 메서드 호출
        int result = f.sum(5, 3);

        // 결과 출력
        System.out.println(result);
    }
}