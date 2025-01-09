package org.example.algorithm.p14;

public class MaxProductMethod2 {
    public static int maxProduct(int[] arr) {
        int n = arr.length;
        return arr[n - 1] * arr[n - 2]; // 가장 큰 두 수를 곱함
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("방법 2 최댓값: " + maxProduct(arr)); // 결과: 20
    }
}
