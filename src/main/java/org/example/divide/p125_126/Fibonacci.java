package org.example.divide.p125_126;

// 피보나치 수열 - 재귀 함수와 동적 계획법(DP)을 이용한 구현

public class Fibonacci {

    // 1. 재귀 함수로 구현 (시간 복잡도: O(2^N))
    public static int fiboRecursive(int N) {
        // 재귀 함수는 종료 조건을 명확히 해야 한다.
        if (N <= 2) {
            return 1; // N이 1 또는 2일 경우, 피보나치 수는 1
        }
        // N번째 피보나치 수는 (N-1)번째와 (N-2)번째 피보나치 수의 합
        return fiboRecursive(N - 1) + fiboRecursive(N - 2);
    }

    // 2. 동적 계획법(DP)으로 구현 (시간 복잡도: O(N))
    public static int fiboDP(int N) {
        if (N <= 2) {
            return 1; // N이 1 또는 2일 경우, 피보나치 수는 1
        }

        // DP 배열 초기화
        int[] dp = new int[N + 1]; // 1부터 N까지 사용하기 위해 크기를 N+1로 설정
        dp[1] = 1; // 첫 번째 피보나치 수
        dp[2] = 1; // 두 번째 피보나치 수

        // 점화식을 이용하여 피보나치 수 계산
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // 점화식: dp[i] = dp[i-1] + dp[i-2]
        }

        return dp[N]; // N번째 피보나치 수 반환
    }

    // 메인 메서드: 두 방식의 결과를 비교
    public static void main(String[] args) {
        //int N = 10; // 10번째 피보나치 수를 계산
        int N = 6;

        // 재귀 함수를 이용한 결과 출력
        long start = System.nanoTime();
        System.out.println("재귀 함수로 계산한 " + N + "번째 피보나치 수: " + fiboRecursive(N));
        System.out.println(System.nanoTime() - start);

        // 동적 계획법을 이용한 결과 출력
        start = System.nanoTime();
        System.out.println("동적 계획법으로 계산한 " + N + "번째 피보나치 수: " + fiboDP(N));
        System.out.println(System.nanoTime() - start);
    }
}