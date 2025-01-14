package org.example.divide.p120;

// 문제: 동적 계획법을 사용하여 최소 동전 개수로 1000원을 만드는 방법
import java.util.Arrays;

public class MinCoinsDP {

    public static void main(String[] args) {
        int amount = 1000; // 목표 금액
        int[] coins = {500, 100}; // 사용할 동전 종류

        // 동적 계획법을 위한 배열 초기화
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE); // 초기값: 무한대
        dp[0] = 0; // 금액 0을 만들기 위해 필요한 동전 개수는 0

        // 동적 계획법으로 최소 동전 개수 계산
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // 결과 출력
        if (dp[amount] != Integer.MAX_VALUE) {
            System.out.println("최소 동전 개수: " + dp[amount]);
        } else {
            System.out.println("해당 금액을 만들 수 없습니다.");
        }
    }
}
