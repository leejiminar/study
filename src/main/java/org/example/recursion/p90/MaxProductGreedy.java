package org.example.recursion.p90;

public class MaxProductGreedy {
    public static int findMaxProduct(int[] arr) {
        // 배열이 이미 정렬되어 있으므로 가장 큰 두 값은 배열의 마지막 두 요소
        int n = arr.length;

        // 마지막 요소와 두 번째로 마지막 요소를 곱한 값 반환
        return arr[n - 1] * arr[n - 2];
    }

    public static void main(String[] args) {
        // 예제 배열 (오름차순으로 정렬된 양의 정수)
        int[] arr = {1, 3, 5, 7, 9};

        // 최대 곱을 계산하여 출력
        System.out.println("최댓값 (그리디): " + findMaxProduct(arr));
    }
}
