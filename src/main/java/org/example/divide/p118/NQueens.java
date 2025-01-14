package org.example.divide.p118;

// 문제: 백트래킹 기법을 사용하여 N-Queens 문제 해결
import java.util.Scanner;

public class NQueens {
    private static int n; // 체스판 크기 (N x N)
    private static int[] board; // 각 행의 퀸 위치를 저장 (board[row] = col)
    private static int solutions; // 가능한 해의 수

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 사용자로부터 N 입력받기
        System.out.print("N (체스판 크기): ");
        n = scanner.nextInt(); // 4 입력하고 테스트해 보기
        board = new int[n]; // N개의 행에 대한 퀸 위치 저장 배열 초기화
        solutions = 0; // 가능한 해 초기화

        // 백트래킹 시작
        solve(0);

        // 결과 출력
        System.out.println("총 가능한 해: " + solutions);
    }

    /**
     * 퀸을 배치하는 백트래킹 함수
     *
     * @param row 현재 처리 중인 행
     */
    private static void solve(int row) {
        // 기저 사례: 모든 퀸을 배치 완료한 경우
        if (row == n) {
            solutions++; // 가능한 해 증가
            printBoard(); // 현재 배치 출력 (옵션)
            return;
        }

        // 현재 행(row)에 모든 열(col)을 시도
        for (int col = 0; col < n; col++) {
            if (isSafe(row, col)) { // 현재 위치가 안전한 경우
                board[row] = col; // 퀸 배치
                solve(row + 1); // 다음 행으로 이동
                // 백트래킹: board[row]를 덮어쓰므로 별도의 undo 작업 필요 없음
            }
        }
    }

    /**
     * 현재 위치가 안전한지 확인하는 함수
     *
     * @param row 현재 행
     * @param col 현재 열
     * @return 퀸을 배치할 수 있으면 true, 그렇지 않으면 false
     */
    private static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            // 같은 열에 퀸이 있는 경우
            if (board[i] == col) {
                return false;
            }
            // 대각선에 퀸이 있는 경우
            if (Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true; // 안전한 위치
    }

    /**
     * 현재 체스판 상태를 출력하는 함수 (옵션)
     */
    private static void printBoard() {
        System.out.println("해 #" + solutions);
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row] == col) {
                    System.out.print("Q "); // 퀸이 있는 위치
                } else {
                    System.out.print(". "); // 빈 공간
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
