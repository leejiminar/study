package org.example.recursion.p104;

import java.util.Arrays;

public class TimSort {
    // 최소 런 크기 (하위 배열 크기). 일반적으로 32 또는 64로 설정
    static int RUN = 32;

    /**
     * 삽입 정렬 함수
     * - 작은 배열에서 효율적으로 작동하는 정렬 알고리즘
     * - 지정된 범위(left부터 right까지)를 정렬
     * @param arr  정렬할 배열
     * @param left 정렬 범위의 시작 인덱스
     * @param right 정렬 범위의 끝 인덱스
     */
    public static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = arr[i]; // 현재 값을 저장
            int j = i - 1;

            // 현재 값을 올바른 위치로 이동
            while (j >= left && arr[j] > temp) {
                arr[j + 1] = arr[j]; // 요소를 오른쪽으로 이동
                j--;
            }
            arr[j + 1] = temp; // 현재 값을 올바른 위치에 삽입
        }
    }

    /**
     * 병합 함수
     * - 두 개의 정렬된 하위 배열을 병합하여 하나의 정렬된 배열로 만듦
     * @param arr  병합할 배열
     * @param left 병합 범위의 시작 인덱스
     * @param mid  병합 범위의 중간 인덱스
     * @param right 병합 범위의 끝 인덱스
     */
    public static void merge(int[] arr, int left, int mid, int right) {
        // 첫 번째와 두 번째 하위 배열의 크기 계산
        int len1 = mid - left + 1, len2 = right - mid;

        // 두 하위 배열을 임시 배열로 복사
        int[] leftArr = new int[len1];
        int[] rightArr = new int[len2];
        System.arraycopy(arr, left, leftArr, 0, len1);
        System.arraycopy(arr, mid + 1, rightArr, 0, len2);

        // 병합 프로세스: 두 배열의 요소를 비교하며 정렬
        int i = 0, j = 0; // 왼쪽 및 오른쪽 배열의 인덱스
        int k = left;     // 병합된 결과를 저장할 배열의 인덱스

        while (i < len1 && j < len2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++]; // 왼쪽 배열의 요소 추가
            } else {
                arr[k++] = rightArr[j++]; // 오른쪽 배열의 요소 추가
            }
        }

        // 남아 있는 요소를 추가 (한쪽 배열이 끝난 경우)
        while (i < len1) {
            arr[k++] = leftArr[i++];
        }
        while (j < len2) {
            arr[k++] = rightArr[j++];
        }
    }

    /**
     * Tim Sort 함수
     * - 배열을 RUN 크기만큼 나누어 삽입 정렬을 적용
     * - 이후 작은 정렬된 배열들을 병합하여 전체 정렬
     * @param arr 정렬할 배열
     * @param n   배열의 크기
     */
    public static void timSort(int[] arr, int n) {
        // 배열을 RUN 크기로 나누어 삽입 정렬 수행
        for (int i = 0; i < n; i += RUN) {
            // 현재 블록의 끝 인덱스 계산 (배열 범위를 초과하지 않도록 처리)
            insertionSort(arr, i, Math.min((i + RUN - 1), (n - 1)));
        }

        // 병합 단계: 블록 크기를 점점 증가시키며 병합
        for (int size = RUN; size < n; size = 2 * size) {
            for (int left = 0; left < n; left += 2 * size) {
                // 중간점과 오른쪽 끝 계산
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (n - 1));

                // 병합 수행 (mid가 right보다 작을 때만 병합)
                if (mid < right) {
                    merge(arr, left, mid, right);
                }
            }
        }
    }

    /**
     * 메인 함수
     * - Tim Sort 알고리즘을 테스트하기 위한 예제
     */
    public static void main(String[] args) {
        // 테스트 배열
        int[] arr = {5, 21, 7, 23, 19, 1, 2, 45, 33, 25, 10};
        System.out.println("정렬 전 배열: " + Arrays.toString(arr));

        // Tim Sort 실행
        timSort(arr, arr.length);

        // 정렬된 결과 출력
        System.out.println("정렬 후 배열: " + Arrays.toString(arr));
    }
}