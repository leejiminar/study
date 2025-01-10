package org.example.recursion.p98_104;

public class SortingAlgorithms {

    /*
        삽입 정렬(Insertion Sort)
        시간 복잡도
            O(n)   (최선) - 이미 정렬된 경우
            O(n^2) (평균, 최악)
            O(1)   (평균 공간 복잡도)
    */
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i]; // 현재 삽입하려는 값
            int j = i - 1;

            // key보다 큰 값을 오른쪽으로 이동
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key; // key 값을 올바른 위치에 삽입
        }
    }

    /*
        버블 정렬(Bubble Sort)
        시간 복잡도
            O(n)   (최선) - 이미 정렬된 경우
            O(n^2) (평균, 최악)
            O(1)   (평균 공간 복잡도)
    */
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean swapped = false; // 최적화를 위한 스왑 확인 플래그
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // 인접 요소를 비교하고 스왑
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break; // 이미 정렬된 경우 루프 종료
        }
    }

    /*
        합병 정렬(Merge Sort)
        시간 복잡도
            O(n log n) (최선, 평균, 최악)
            O(n)       (평균 공간 복잡도)
    */
    public static void mergeSort(int[] array) {
        if (array.length < 2) return;

        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        // 배열 분할
        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);

        mergeSort(left);
        mergeSort(right);

        merge(array, left, right);
    }

    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // 두 배열을 병합
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // 남은 요소 추가
        while (i < left.length) {
            array[k++] = left[i++];
        }

        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    /*
        퀵 정렬(Quick Sort)
        시간 복잡도
            O(n log n) (최선, 평균)
            O(n^2)     (최악)
            O(log n)   (평균 공간 복잡도)
    */
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high); // 피벗 정렬
            quickSort(array, low, pivotIndex - 1); // 왼쪽 부분 정렬
            quickSort(array, pivotIndex + 1, high); // 오른쪽 부분 정렬
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high]; // 마지막 요소를 피벗으로 선택
        int i = low - 1; // 작은 요소들의 끝 인덱스

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                // 스왑
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // 피벗을 올바른 위치에 놓음
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    /*
        힙 정렬(Heap Sort)
        시간 복잡도
            O(n log n) (최선, 평균, 최악)
            O(1)       (평균 공간 복잡도)
    */
    public static void heapSort(int[] array) {
        int n = array.length;

        // 최대 힙 생성
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // 정렬
        for (int i = n - 1; i > 0; i--) {
            // 루트(최대값)과 끝 요소를 스왑
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // 힙 크기를 줄이고 재정렬
            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int n, int i) {
        int largest = i; // 루트 노드
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // 왼쪽 자식이 루트보다 크다면
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        // 오른쪽 자식이 현재 최대값보다 크다면
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        // 최대값이 루트가 아니라면 스왑 및 재귀 호출
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            heapify(array, n, largest);
        }
    }

    // Main Method for Testing
    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 5, 6};

        System.out.println("Original Array: ");
        printArray(array);

        /*
            하나씩 주석 풀면서 테스트
        */
        insertionSort(array);
        //bubbleSort(array);
        //mergeSort(array);
        //quickSort(array, 0, array.length - 1);
        //heapSort(array);

        System.out.println("Sorted Array: ");
        printArray(array);
    }

    // Utility method to print arrays
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
