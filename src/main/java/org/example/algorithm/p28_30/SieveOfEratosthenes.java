package org.example.algorithm.p28_30;

import java.util.Arrays;

public class SieveOfEratosthenes {

    // 에라토스테네스의 체를 구현한 메서드
    public static boolean[] sieveOfEratosthenes(int n) {
        // 소수 여부를 저장할 배열 생성 (0부터 n까지 포함하므로 크기는 n+1)
        boolean[] isPrime = new boolean[n + 1];

        // 초기화: 모든 숫자를 소수(true)로 설정
        Arrays.fill(isPrime, true);

        // 0과 1은 소수가 아니므로 false로 설정
        isPrime[0] = false;
        isPrime[1] = false;

        // 2부터 n의 제곱근까지 반복
        for (int i = 2; i * i <= n; i++) {
            // i가 소수인 경우
            if (isPrime[i]) {
                // i의 배수들을 소수가 아니라고 표시
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // 소수 여부를 저장한 배열 반환
        return isPrime;
    }

    public static void main(String[] args) {
        int n = 50; // 2부터 n까지의 숫자 중 소수를 찾음

        // 에라토스테네스의 체 호출
        boolean[] primes = sieveOfEratosthenes(n);

        // 결과 출력
        System.out.println("2부터 " + n + "까지의 소수:");
        for (int i = 2; i <= n; i++) {
            if (primes[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
