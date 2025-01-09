package org.example.algorithm.p8_13;

import java.util.Arrays;

public class TimeComplexityExamples {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        // O(1) - 상수 시간 (Constant Time)
        System.out.println("첫 번째 원소: " + constantTime(arr, 0)); // 배열이 비어있지 않을 때 첫 번째 원소 출력 (Print first element if array is not empty)

        // O(log N) - 로그 시간 (Logarithmic Time)
        System.out.println("이진 탐색 결과 인덱스: " + logarithmicTime(arr, 4)); // 이진 탐색 결과 출력 (Print binary search result)

        // O(N) - 선형 시간 (Linear Time)
        System.out.println("선형 탐색 결과 인덱스: " + linearTime(arr, 4)); // 선형 탐색 결과 출력 (Print linear search result)

        // O(N log N) - 선형 로그 시간 (Linearithmic Time)
        linearithmicTime(arr);
        System.out.println("정렬된 배열: " + Arrays.toString(arr)); // 정렬된 배열 출력 (Print sorted array)

        // O(N^2) - 이차 시간 (Quadratic Time)
        quadraticTime(arr);

        // O(2^N) - 지수 시간 (Exponential Time)
        System.out.println("피보나치 결과: " + exponentialTime(5)); // 피보나치 결과 출력 (Print Fibonacci result)

        // O(N!) - 팩토리얼 시간 (Factorial Time)
        factorialTime("", "ABC"); // 문자열의 모든 순열 생성 및 출력 (Generate and print all permutations of the string)
    }

    // O(1) - 상수 시간 (Constant Time)
    // 배열의 첫 번째 원소를 출력 (Print the first element of the array)
    public static int constantTime(int[] arr, int idx) {
        if (arr.length > 0) {
            return arr[idx];
        }
        return -1;
    }

    // O(log N) - 로그 시간 (Logarithmic Time)
    // 이진 탐색을 수행하여 타겟 값을 찾음 (Perform binary search to find the target value)
    public static int logarithmicTime(int[] arr, int target) {
        int left = 0, right = arr.length - 1; // 왼쪽과 오른쪽 포인터 초기화 (Initialize left and right pointers)
        while (left <= right) {
            int mid = left + (right - left) / 2; // 중간값 계산 (Calculate mid-point)
            if (arr[mid] == target) return mid; // 타겟 값을 찾은 경우 인덱스 반환 (Return index if target is found)
            if (arr[mid] < target) left = mid + 1; // 타겟이 중간값보다 크면 오른쪽 검색 (Search right half if target is greater)
            else right = mid - 1; // 타겟이 중간값보다 작으면 왼쪽 검색 (Search left half if target is smaller)
        }
        return -1; // 타겟 값을 찾지 못한 경우 -1 반환 (Return -1 if target is not found)
    }

    // O(N) - 선형 시간 (Linear Time)
    // 배열에서 타겟 값을 순차적으로 검색 (Search target value sequentially in the array)
    public static int linearTime(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i; // 타겟 값을 찾으면 인덱스 반환 (Return index if target is found)
        }
        return -1; // 타겟 값을 찾지 못한 경우 -1 반환 (Return -1 if target is not found)
    }

    // O(N log N) - 선형 로그 시간 (Linearithmic Time)
    // 배열을 정렬 (Sort the array)
    public static void linearithmicTime(int[] arr) {
        Arrays.sort(arr); // 정렬 함수는 O(N log N)의 시간 복잡도를 가짐 (Sorting function has O(N log N) time complexity)
    }

    // O(N^2) - 이차 시간 (Quadratic Time)
    // 배열 내 모든 쌍을 출력 (Print all pairs in the array)
    public static void quadraticTime(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.println(arr[i] + ", " + arr[j]); // 각 쌍 출력 (Print each pair)
            }
        }
    }

    // O(2^N) - 지수 시간 (Exponential Time)
    // 피보나치 수열을 재귀적으로 계산 (Calculate Fibonacci sequence recursively)
    public static int exponentialTime(int n) {
        if (n <= 1) return n; // 기본 조건: n이 0 또는 1일 경우 (Base cases: if n is 0 or 1)
        return exponentialTime(n - 1) + exponentialTime(n - 2); // 피보나치 계산 (Calculate Fibonacci)
    }

    // O(N!) - 팩토리얼 시간 (Factorial Time)
    // 문자열의 모든 순열 생성 (Generate all permutations of a string)
    public static void factorialTime(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            System.out.println(prefix); // 순열 출력 (Print permutation)
        } else {
            for (int i = 0; i < n; i++) {
                factorialTime(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n)); // 순열 생성 재귀 호출 (Recursive call to generate permutations)
            }
        }
    }
}
