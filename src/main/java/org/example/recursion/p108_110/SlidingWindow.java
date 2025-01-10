package org.example.recursion.p108_110;

// 문제: 주어진 배열 A와 정수 M에 대해, 길이가 M인 연속된 부분 배열의 합 중 최댓값을 구하는 프로그램을 작성하세요.

public class SlidingWindow {
    public static void main(String[] args) {
        // 주어진 배열과 M의 값
        int[] A = {-22, 87, 62, 71, -27, -62, -72, 68, 82, 4};
        int M = 3; // 부분 배열의 길이

        // 슬라이딩 윈도우 알고리즘을 통해 최대 합을 계산
        int maxSum = findMaxSum(A, M);

        // 결과 출력
        System.out.println("최대 합: " + maxSum);
    }

    /**
     * 슬라이딩 윈도우 알고리즘을 사용하여 길이가 M인 연속된 부분 배열의 최대 합을 찾는 메서드
     *
     * @param arr 입력 배열
     * @param m 부분 배열의 길이
     * @return 최대 합
     */
    public static int findMaxSum(int[] arr, int m) {
        // 배열의 길이가 M보다 작으면 계산할 수 없음
        if (arr.length < m) {
            throw new IllegalArgumentException("배열의 길이가 M보다 작습니다.");
        }

        // 첫 번째 윈도우의 합 계산
        int windowSum = 0;
        for (int i = 0; i < m; i++) {
            windowSum += arr[i];
        }

        // 최대 합 초기화
        int maxSum = windowSum;

        // 슬라이딩 윈도우 적용
        for (int i = m; i < arr.length; i++) {
            // 윈도우를 오른쪽으로 이동: 이전 윈도우의 첫 번째 값을 빼고 새로운 값을 더함
            windowSum = windowSum - arr[i - m] + arr[i];

            // 최대 합 갱신
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
}
