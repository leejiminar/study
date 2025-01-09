package org.example.algorithm.p31_32;

public class PalindromeChecker {
    public static void main(String[] args) {
        // 검사할 텍스트 값
        String input = "level";

        // 결과를 확인하고 출력
        if (isPalindrome(input)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
    }

    /**
     * 주어진 문자열이 회문인지 확인하는 메서드
     * @param str 검사할 문자열
     * @return 회문이면 true, 아니면 false
     */
    public static boolean isPalindrome(String str) {
        // 입력 문자열의 공백과 대소문자를 무시하기 위해 전처리
        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // for문을 사용하여 양 끝에서부터 문자를 비교
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false; // 회문이 아님을 반환
            }
        }

        return true; // 모든 문자가 일치하면 회문임
    }
}
