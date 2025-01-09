package org.example.algorithm.p22_23;

public class EuclideanAlgorithm {
    // 최대공약수를 구하는 메서드
    public static int gcd(int a, int b) {
        while (b != 0) { // 나머지가 0이 될 때까지 반복
            int r = a % b; // 나머지 구하기
            a = b;        // 큰 수를 작은 수로 교체
            b = r;        // 작은 수를 나머지로 교체
        }
        return a; // 마지막 남은 a가 최대공약수
    }

    // 최소공배수를 구하는 메서드
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b); // LCM = (a * b) / GCD
    }

    public static void main(String[] args) {
        // 예제: 두 숫자의 최대공약수와 최소공배수 구하기
        //int num1 = 48;
        //int num2 = 18;
        int num1 = 1071;
        int num2 = 1029;

        int gcdResult = gcd(num1, num2);
        int lcmResult = lcm(num1, num2);

        System.out.println("최대공약수: " + gcdResult);
        System.out.println("최소공배수: " + lcmResult);
    }
}
