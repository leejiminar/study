package org.example.structure.p46;

public class Main {
    public static void main(String[] args) {
        // 기존 배열
        int[] arr = {1, 2, 3, 4};

        // 새로운 배열 (길이가 5)
        int[] newArr = new int[arr.length + 1];

        // 첫 번째 자리에 0 넣기
        newArr[0] = 0;

        // 기존 배열의 값을 새로운 배열로 복사
        for (int i = 0; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }

        // 결과 출력
        for (int num : newArr) {
            System.out.print(num + " ");
        }
    }
}
