package org.example.algorithm.p33_36;

public class VPSCheckerWithSum {
    public static void main(String[] args) {
        // 검사할 문자열을 고정값으로 설정
        String input = "(())";
        //String input = ")(()";
        //String input = "()((";

        // 결과를 확인하고 출력
        if (isValidParenthesisString(input)) {
            System.out.println("The string is a valid parenthesis string (VPS).");
        } else {
            System.out.println("The string is NOT a valid parenthesis string (VPS).");
        }
    }

    /**
     * 문자열을 순회하며 합을 계산하여 올바른 괄호 문자열인지 확인
     * @param s 검사할 문자열
     * @return 올바른 괄호 문자열이면 true, 아니면 false
     */
    public static boolean isValidParenthesisString(String s) {
        int sum = 0; // 합계를 저장하는 변수

        // 문자열의 각 문자를 순회
        for (char c : s.toCharArray()) {
            if (c == '(') {
                sum += 1; // 여는 괄호는 +1
            } else if (c == ')') {
                sum -= 1; // 닫는 괄호는 -1
            }

            // 중간에 합계가 음수가 되면 올바르지 않은 괄호 문자열
            if (sum < 0) {
                return false;
            }
        }

        // 최종적으로 합이 0이면 올바른 괄호 문자열
        return sum == 0;
    }
}
