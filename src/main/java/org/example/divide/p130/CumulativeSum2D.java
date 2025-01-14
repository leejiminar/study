package org.example.divide.p130;

// 문제: 주어진 2차원 배열에서 특정 구간의 합을 빠르게 계산하기 위해 2차원 누적합(Prefix Sum) 기법을 사용

public class CumulativeSum2D {
    public static void main(String[] args) {
        // 1. 주어진 2차원 배열 초기화
        int[][] array = {
                {1, 2, 3, 4, 5},
                {1, 5, 1, 4, 3},
                {2, 5, 3, 3, 1},
                {3, 2, 5, 4, 3},
                {2, 4, 4, 5, 1}
        }; // 5x5 배열
        // 배열 크기
        int rows = array.length;
        int cols = array[0].length;
        //출력
        System.out.println("원본 배열:");
        for (int[] row : array) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        // 2. 누적합 배열 생성
        // pSum[i][j]: (1,1)부터 (i,j)까지의 합
        int[][] pSum = new int[rows + 1][cols + 1]; // 1-based indexing을 위해 +1 크기

        // 3. 누적합 계산
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                pSum[i][j] = array[i - 1][j - 1] // 현재 위치 값
                           + pSum[i - 1][j]      // 바로 위의 누적합
                           + pSum[i][j - 1]      // 바로 왼쪽의 누적합
                           - pSum[i - 1][j - 1]; // 중복된 부분 제거
            }
        }
        // 출력
        System.out.println("\n누적합 배열:");
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                System.out.print(pSum[i][j] + " ");
            }
            System.out.println();
        }

        // 4. 테스트용 쿼리: 특정 구간의 합 구하기 (1-based index)
        // (2,2)부터 (4,4)까지의 합 구하기
        int x1 = 2, y1 = 2; // 시작 인덱스
        int x2 = 4, y2 = 4; // 끝 인덱스

        // 구간 합 계산
        int sum = pSum[x2][y2]
                - pSum[x1 - 1][y2]
                - pSum[x2][y1 - 1]
                + pSum[x1 - 1][y1 - 1];
        // 출력
        System.out.println("\n구간 합 [(" + x1 + "," + y1 + ") ~ (" + x2 + "," + y2 + ")]: " + sum);
    }
}