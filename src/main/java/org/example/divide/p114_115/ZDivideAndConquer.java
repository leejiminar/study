package org.example.divide.p114_115;

// 문제: 분할 정복 기법을 사용하여 Z-모양 순서로 배열을 방문할 때, 특정 좌표를 몇 번째로 방문하는지 계산
import java.util.Scanner;

public class ZDivideAndConquer {
    // 방문 순서를 저장할 전역 변수
    private static int result = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 사용자 입력 받기: n, r, c
        System.out.print("n (배열 크기 2^n): ");
        int n = scanner.nextInt(); // 2^n 크기의 배열
        System.out.print("r (행 번호): ");
        int r = scanner.nextInt(); // 목표 행
        System.out.print("c (열 번호): ");
        int c = scanner.nextInt(); // 목표 열

        // 분할 정복 함수 호출
        solve((int) Math.pow(2, n), 0, 0, r, c);

        // 결과 출력
        System.out.println("결과: " + result);
    }

    /**
     * 분할 정복 함수
     *
     * @param size 현재 사각형의 한 변의 길이
     * @param x 현재 사각형의 시작 행
     * @param y 현재 사각형의 시작 열
     * @param r 목표 행
     * @param c 목표 열
     */
    private static void solve(int size, int x, int y, int r, int c) {
        // 기저 사례: 크기가 1인 경우
        if (size == 1) {
            if (x == r && y == c) {
                // 목표 위치에 도달하면 결과 출력 및 종료
                System.out.println("방문 순서: " + result);
                return;
            }
            result++; // 방문 순서를 증가
            return;
        }

        // 현재 사각형의 한 변의 절반 길이
        int half = size / 2;

        // 1사분면: (x, y) ~ (x + half - 1, y + half - 1)
        if (r < x + half && c < y + half) {
            solve(half, x, y, r, c);
        } else {
            result += half * half; // 1사분면 크기만큼 방문 순서 증가
        }

        // 2사분면: (x, y + half) ~ (x + half - 1, y + size - 1)
        if (r < x + half && c >= y + half) {
            solve(half, x, y + half, r, c);
        } else {
            result += half * half; // 2사분면 크기만큼 방문 순서 증가
        }

        // 3사분면: (x + half, y) ~ (x + size - 1, y + half - 1)
        if (r >= x + half && c < y + half) {
            solve(half, x + half, y, r, c);
        } else {
            result += half * half; // 3사분면 크기만큼 방문 순서 증가
        }

        // 4사분면: (x + half, y + half) ~ (x + size - 1, y + size - 1)
        if (r >= x + half && c >= y + half) {
            solve(half, x + half, y + half, r, c);
        } else {
            result += half * half; // 4사분면 크기만큼 방문 순서 증가
        }
    }
}
