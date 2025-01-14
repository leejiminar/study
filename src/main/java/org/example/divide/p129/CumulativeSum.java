package org.example.divide.p129;

// 문제: 주어진 배열에서 특정 구간의 합을 빠르게 계산하기 위해 누적합(Cumulative Sum) 기법을 사용

public class CumulativeSum {
    public static void main(String[] args) {
        // 정해진 숫자 배열
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // 크기 N=10
        // 출력
        System.out.print("배열            : ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 누적합 배열 계산
        int[] cumulativeSum = new int[array.length];
        cumulativeSum[0] = array[0]; // 첫 번째 원소는 그대로 저장
        for (int i = 1; i < array.length; i++) {
            cumulativeSum[i] = cumulativeSum[i - 1] + array[i];
        }
        // 출력
        System.out.print("누적합 배열      : ");
        for (int num : cumulativeSum) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 테스트용 쿼리: 특정 구간의 합 구하기 (1-based index)
        int start = 3; // 시작 인덱스 (1-based)
        int end = 5; // 끝 인덱스 (1-based)
        // 누적합 배열을 사용하여 구간 합 계산
        int sum = (start > 1) ? cumulativeSum[end - 1] - cumulativeSum[start - 2] : cumulativeSum[end - 1];
        // 출력
        System.out.println("구간 [" + start + ", " + end + "]의 합: " + sum);
    }
}
