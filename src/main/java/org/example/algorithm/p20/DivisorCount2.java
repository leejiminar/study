package org.example.algorithm.p20;

// 방법2: 제곱수를 고려하여 약수의 개수 계산
public class DivisorCount2 {
    public static int countDivisors_1(int N) {
        int count = 0;
        // i가 N의 제곱근 이하일 때까지 반복합니다.
        // 이를 통해 약수 쌍 (i와 N / i)을 동시에 찾습니다.
        for (int i = 1; i * i <= N; i++) {
            if (N % i == 0) {
                count += 2; // i와 N / i가 모두 약수이므로 각각 카운트합니다. 즉, 약수 쌍을 고려합니다.
                if (i * i == N) {
                    count--; // i가 N의 제곱근인 경우 (i * i == N), 중복으로 카운트된 약수를 하나 제거합니다.
                }
            }
        }

        return count;
    }

    public static int countDivisors_2(int N) {
        int count = 0;
        for (int i = 1; i <= (long)Math.sqrt(N); i++) { // sqrt(제곱근 √)
            if (N % i == 0) {
                count++;
            }
        }

        count *= 2;
        if (Math.pow((long)Math.sqrt(N), 2) == N) {    // pow(거듭제곱), sqrt(제곱근 √)
            count--;
        }

        return count;
    }

    public static void main(String[] args) {
        int N = 36; // 예시 값

        long start = System.nanoTime();
        System.out.println("Divisors count (Method 2-1): " + countDivisors_1(N));
        System.out.println(System.nanoTime() - start);

        start = System.nanoTime();
        System.out.println("Divisors count (Method 2-2): " + countDivisors_2(N));
        System.out.println(System.nanoTime() - start);
    }
}
