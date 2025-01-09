package org.example.algorithm.p33_36;

import java.util.Stack;

public class ValidParenthesisString {
    public static void main(String[] args) {
        // 검사할 문자열을 고정값으로 설정
        String input = "(())";

        // 결과를 확인하고 출력
        if (isValidParenthesisString(input)) {
            System.out.println("The string is a valid parenthesis string (VPS).\nInput: " + input);
        } else {
            System.out.println("The string is NOT a valid parenthesis string (VPS).\nInput: " + input);
        }
    }

    /**
     * 주어진 문자열이 올바른 괄호 문자열인지 확인하는 메서드
     * @param s 검사할 문자열
     * @return 올바른 괄호 문자열이면 true, 아니면 false
     */
    public static boolean isValidParenthesisString(String s) {
        Stack<Character> stack = new Stack<>(); // 스택을 사용하여 괄호를 관리

        // 문자열의 각 문자를 순회
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c); // 여는 괄호를 스택에 추가
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false; // 닫는 괄호가 스택의 여는 괄호와 짝을 이루지 못함
                }
                stack.pop(); // 스택에서 짝이 맞는 여는 괄호 제거
            }
        }

        return stack.isEmpty(); // 스택이 비어 있으면 올바른 괄호 문자열임
    }
}