package org.example.divide.p117;

public class SudokuSolver {
    private static final int SIZE = 9; // 스도쿠 보드의 크기 (9x9)

    public static void main(String[] args) {
        // 스도쿠 퍼즐 초기 상태 (0은 빈칸을 의미)
        int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        // 스도쿠 퍼즐을 해결하고 결과를 출력
        if (solveSudoku(board)) {
            System.out.println("스도쿠를 성공:");
            printBoard(board);
        } else {
            System.out.println("스도쿠를 실패.");
        }
    }

    /**
     * 스도쿠를 해결하는 백트래킹 메서드
     *
     * @param board 스도쿠 퍼즐 배열
     * @return 해결 가능 여부 (true: 해결됨, false: 해결 불가)
     */
    private static boolean solveSudoku(int[][] board) {
        // 보드의 각 행(row)과 열(col)을 탐색
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) {                 // 빈칸(0)을 찾음
                    for (int num = 1; num <= 9; num++) {    // 1부터 9까지의 숫자를 순서대로 시도
                        if (isSafe(board, row, col, num)) { // 현재 숫자를 해당 위치에 넣어도 되는지 검사
                            board[row][col] = num;          // 숫자를 임시로 넣음
                            if (solveSudoku(board)) {       // → 다음 빈칸에 대해 재귀 호출
                                return true;                // 해결된 경우
                            }
                            board[row][col] = 0;            // → 해결되지 않으면 초기화 (백트래킹)
                        }
                    }
                    return false;                           // 가능한 숫자가 없으면 실패
                }
            }
        }
        return true; // 모든 빈칸이 채워졌으면 해결 완료
    }

    /**
     * 특정 숫자를 해당 위치에 놓을 수 있는지 검사
     *
     * @param board 스도쿠 퍼즐 배열
     * @param row 행 인덱스
     * @param col 열 인덱스
     * @param num 놓을 숫자
     * @return 안전 여부 (true: 가능, false: 불가능)
     */
    private static boolean isSafe(int[][] board, int row, int col, int num) {
        // 같은 행(row)에 같은 숫자가 있는지 확인
        for (int x = 0; x < SIZE; x++) {
            if (board[row][x] == num) {
                return false;
            }
        }

        // 같은 열(col)에 같은 숫자가 있는지 확인
        for (int x = 0; x < SIZE; x++) {
            if (board[x][col] == num) {
                return false;
            }
        }

        // 3x3 박스 내부에서 같은 숫자가 있는지 확인
        int startRow = row - row % 3; // 3x3 박스의 시작 행
        int startCol = col - col % 3; // 3x3 박스의 시작 열
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }

        return true; // 위 조건을 모두 만족하면 안전함
    }

    /**
     * 스도쿠 보드를 출력하는 메서드
     *
     * @param board 스도쿠 퍼즐 배열
     */
    private static void printBoard(int[][] board) {
        // 행(row)과 열(col)을 순회하며 보드 출력
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println(); // 행 끝에서 줄바꿈
        }
    }
}
