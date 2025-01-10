package org.example.recursion.p106_107;

// 문제: 주어진 배열 A와 정수 M에 대해, 연속된 부분 배열의 합이 M이 되는 경우의 수를 구하세요.

public class TwoPointer {
    public static void main(String[] args) {
        // 주어진 배열과 M의 값
        //int[] A = {10, 20, 30, 40, 10, 20, 30, 30, 40};
        int[] A = {10, 5, 5, 5, 5, 20, 10, 50, 40};
        int M = 30; // 목표 합 (PDF 내용) → 𝐴 = 10, 20, 30, 40, 10, 20, 30, 30, 40 , 𝑀 = 30이라면?

        // 투 포인터 알고리즘을 사용하여 경우의 수를 계산
        int count = findSubarrayCount(A, M);

        // 결과 출력
        System.out.println("부분 배열의 합이 " + M + "이 되는 경우의 수: " + count);
    }

    /**
     * 투 포인터 알고리즘을 사용하여 부분 배열의 합이 M이 되는 경우의 수를 계산하는 메서드
     *
     * @param arr 입력 배열
     * @param m 목표 합
     * @return 조건을 만족하는 부분 배열의 수
     */
    public static int findSubarrayCount(int[] arr, int m) {
        int s = 0; // 시작 포인터
        int e = 0; // 끝 포인터
        int sum = 0; // 현재 부분합
        int count = 0; // 조건을 만족하는 부분 배열의 수

        // 끝 포인터를 배열의 끝까지 이동
        while (e < arr.length) {
            // 부분합에 e 위치의 값을 추가
            sum += arr[e];

            // 부분합이 목표 값보다 크거나 같으면, 시작 포인터를 이동하여 조건을 만족하도록 조정
            while (sum > m && s <= e) {
                sum -= arr[s]; // s 위치의 값을 제거
                s++; // 시작 포인터 이동
            }

            // 부분합이 목표 값과 같으면 카운트 증가
            if (sum == m) {
                count++;
            }

            // 끝 포인터 이동
            e++;
        }

        return count;
    }
}
