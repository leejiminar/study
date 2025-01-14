package org.example.divide.p112;

// 문제: 분할 정복의 대표적인 예인 합병 정렬(Merge Sort)을 구현하여 주어진 배열을 정렬하세요.

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        // 정렬할 배열
        int[] array = {6, 5, 3, 1, 8, 7, 2, 4};

        // Merge Sort를 이용해 배열 정렬
        mergeSort(array, 0, array.length - 1);
        //Arrays.sort(array);

        // 결과 출력
        System.out.println("정렬된 배열: " + Arrays.toString(array));
    }

    /**
     * Merge Sort 메서드: 분할 정복 알고리즘으로 배열을 정렬
     *
     * @param arr 입력 배열
     * @param left 시작 인덱스
     * @param right 끝 인덱스
     */
    public static void mergeSort(int[] arr, int left, int right) {
        // 기저 사례: 배열의 크기가 1 이하일 경우
        if (left >= right) {
            return;
        }

        // 배열을 두 부분으로 나누기 위한 중간점 계산
        int mid = (left + right) / 2;

        // Divide 단계: 왼쪽과 오른쪽 부분 배열로 재귀적으로 정렬
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        // Conquer 단계: 두 부분 배열을 합쳐서 정렬
        merge(arr, left, mid, right);
    }

    /**
     * 두 부분 배열을 병합하는 메서드
     *
     * @param arr 입력 배열
     * @param left 시작 인덱스
     * @param mid 중간 인덱스
     * @param right 끝 인덱스
     */
    public static void merge(int[] arr, int left, int mid, int right) {
        // 두 부분 배열의 크기 계산
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // 임시 배열 생성
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // 데이터 복사
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        // 병합 과정
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // 남은 요소들 복사
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
