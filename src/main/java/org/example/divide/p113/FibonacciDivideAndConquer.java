package org.example.divide.p113;

// 문제: 분할 정복 기법을 사용하여 피보나치 수열의 값을 계산하는 프로그램 작성

public class FibonacciDivideAndConquer {
    public static void main(String[] args) {
        // N번째 피보나치 수를 구합니다.
        int N = 6; // 예시: F(6) 계산

        // 결과 출력
        System.out.println("F(" + N + ") = " + fibonacci(N));
    }

    /**
     * 피보나치 수열 계산 메서드
     * 분할 정복 기법을 활용하여 F(N)을 재귀적으로 계산합니다.
     *
     * @param n 피보나치 수열의 인덱스 (1부터 시작)
     * @return F(n) 값
     */
    public static int fibonacci(int n) {
        // 기저 사례: N이 1 또는 2인 경우 1 반환
        if (n <= 2) {
            return 1;
        }

        // Divide: F(n) = F(n-1) + F(n-2)
        // Conquer: 작은 문제들의 결과를 더하여 큰 문제를 해결
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
