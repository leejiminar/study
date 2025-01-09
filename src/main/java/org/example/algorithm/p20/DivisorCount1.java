package org.example.algorithm.p20;

// 방법1: 1부터 N까지 나누어 나머지가 0인 경우를 체크
public class DivisorCount1 {
    public static int countDivisors(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int N = 36; // 예시 값
        System.out.println("Divisors count (Method 1): " + countDivisors(N));
    }
}