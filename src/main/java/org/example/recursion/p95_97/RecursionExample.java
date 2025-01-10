package org.example.recursion.p95_97;

public class RecursionExample {

    // 팩토리얼 계산을 위한 재귀 함수
    public static int factorial(int n) {
        // 1. 기본 사례(Base Case):
        //    재귀 함수가 끝나는 조건. n이 0이거나 1이면 더 이상 재귀 호출하지 않음.
        if (n == 0 || n == 1) {
            return 1; // 팩토리얼 0!과 1!은 1로 정의됨.
        }

        // 2. 재귀 사례(Recursive Case):
        //    문제를 더 작은 부분 문제로 나눔.
        //    현재 숫자 n을 n-1의 팩토리얼 결과와 곱함.
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        // 테스트를 위한 입력 값 설정
        int number = 5; // 팩토리얼을 계산할 숫자

        // 재귀 함수 호출 및 결과 출력
        System.out.println(number + "! = " + factorial(number));

        // 추가 설명:
        // 5! 계산 과정:
        // factorial(5) = 5 * factorial(4)
        // factorial(4) = 4 * factorial(3)
        // factorial(3) = 3 * factorial(2)
        // factorial(2) = 2 * factorial(1)
        // factorial(1) = 1 (기본 사례)
        // 따라서 5! = 5 * 4 * 3 * 2 * 1 = 120
    }
}
