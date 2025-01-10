package org.example.recursion.p90;

public class MaxProductBruteForce {
    public static int findMaxProduct(int[] arr) {
        // 배열의 크기
        int n = arr.length;

        // 최댓값을 저장할 변수 (초기값은 음의 무한대)
        int maxProduct = Integer.MIN_VALUE;

        // 모든 쌍 (i, j) 에 대해 곱을 계산
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { // 중복되지 않게 j는 항상 i보다 큰 값
                int product = arr[i] * arr[j]; // i와 j의 곱 계산
                if (product > maxProduct) {   // 현재 최댓값보다 크다면 갱신
                    maxProduct = product;
                }
            }
        }

        // 최댓값 반환
        return maxProduct;
    }

    public static void main(String[] args) {
        // 예제 배열 (오름차순으로 정렬된 양의 정수)
        int[] arr = {1, 3, 5, 7, 9};

        // 최대 곱을 계산하여 출력
        System.out.println("최댓값 (완전 탐색): " + findMaxProduct(arr));
    }
}
