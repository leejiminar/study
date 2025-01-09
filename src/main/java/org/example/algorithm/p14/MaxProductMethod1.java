package org.example.algorithm.p14;

public class MaxProductMethod1 {
    public static int maxProduct(int[] arr) {
        int maxProduct = 0; // 최댓값을 저장할 변수
        int n = arr.length; // 배열의 크기

        for (int i = 0; i < n; i++) {         // 첫 번째 수 선택
            for (int j = i + 1; j < n; j++) { // 두 번째 수 선택 (중복 방지)
                maxProduct = Math.max(maxProduct, arr[i] * arr[j]); // 최댓값 갱신
            }
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("방법 1 최댓값: " + maxProduct(arr)); // 결과: 20
    }
}
