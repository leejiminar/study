package org.example.structure.p72_79;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(); // 스택 생성

        // push 연산
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // 스택 상태 출력
        stack.display();

        // pop 연산
        stack.pop(); // 30 제거
        stack.display();

        // top 연산
        System.out.println("Top element is: " + stack.top());

        // size 연산
        System.out.println("Stack size is: " + stack.size());

        // empty 연산
        System.out.println("Is stack empty? " + stack.empty());

        // peek 연산
        System.out.println("Peek element is: " + stack.peek());

        // 마지막 pop 후 empty 상태 확인
        stack.pop(); // 20 제거
        stack.pop(); // 10 제거
        System.out.println("Is stack empty after all pops? " + stack.empty());
    }
}
