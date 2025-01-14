package org.example.divide.p121;

import java.util.Arrays;

public class MinCoinsDP {

    public static void main(String[] args) {
        int amount = 23;      // 목표 금액 (23원)
        int[] coins = {5, 2}; // 사용할 동전 종류 (5원과 2원)

        // 동적 계획법을 위한 배열 초기화
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE); // 초기값: 무한대
        dp[0] = 0; // 금액 0을 만들기 위해 필요한 동전 개수는 0

        // 동적 계획법으로 최소 동전 개수 계산
        for (int i = 1; i <= amount; i++) { // 1부터 목표 금액까지 반복
            // 동전 5로 계산
            if (i >= 5 && dp[i - 5] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i - 5] + 1);
            }
            // 동전 2로 계산
            if (i >= 2 && dp[i - 2] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i - 2] + 1);
            }
            System.out.println(i +"\t"+ Arrays.toString(dp));
        }

        // 결과 출력
        if (dp[amount] != Integer.MAX_VALUE) {
            System.out.println("최소 동전 개수: " + dp[amount]);
        } else {
            System.out.println("해당 금액을 만들 수 없습니다.");
        }
    }
}