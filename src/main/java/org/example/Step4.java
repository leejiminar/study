package org.example;

//함수형 인터페이스 정의
interface MyFunction3 {
    int sum(int a, int b);
}

public class Step4 {
    public static void main(String[] args) {
        // 람다식을 사용하여 함수형 인터페이스 구현
        MyFunction3 f = (a, b) -> a + b;

        // 람다식 메서드 호출
        int result = f.sum(5, 3);

        // 결과 출력
        System.out.println(result);
    }

}