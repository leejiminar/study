package org.example.recursion.p94;

import java.util.Scanner;

public class CoffeeChangeGreedy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 목표 금액 (커피값)
        System.out.print("금액을 입력하세요 (예: 1000): ");
        int amount = scanner.nextInt();

        // 동전 종류 정의 (500원, 100원)
        int[] coins = {500, 100};
        int coinCount = 0; // 필요한 동전 개수

        System.out.println("잔돈 계산 시작 (그리디 알고리즘 사용)");
        for (int coin : coins) {
            if (amount == 0) break; // 남은 금액이 없으면 종료

            // 현재 동전으로 필요한 개수 계산
            int count = amount / coin;
            coinCount += count; // 총 동전 개수에 추가
            amount %= coin; // 남은 금액 계산

            // 현재 동전 사용 내역 출력
            System.out.println(coin + "원 동전 " + count + "개 사용");
        }

        // 결과 출력
        System.out.println("최소 동전 개수: " + coinCount);
    }
}
