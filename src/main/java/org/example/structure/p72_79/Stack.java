package org.example.structure.p72_79;

import java.util.ArrayList;

/**
 * Java Stack Implementation
 * 주요 연산: push, pop, top, empty, size, peek
 * 스택은 LIFO (Last In First Out) 방식으로 동작하는 자료구조입니다.
 */
class Stack {
    private ArrayList<Integer> stackList; // 스택을 저장할 ArrayList

    // 스택 생성자: ArrayList를 초기화
    public Stack() {
        stackList = new ArrayList<>();
    }

    /**
     * push(): 스택의 맨 위에 새로운 요소를 추가합니다.
     * @param value 추가할 값
     */
    public void push(int value) {
        stackList.add(value);
        System.out.println(value + " pushed to stack");
    }

    /**
     * pop(): 스택의 맨 위 요소를 제거하고 반환합니다.
     * @return 제거된 값
     * @throws IllegalStateException 스택이 비어 있을 때 예외 발생
     */
    public int pop() {
        if (stackList.isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot pop.");
        }
        int value = stackList.remove(stackList.size() - 1);
        System.out.println(value + " popped from stack");
        return value;
    }

    /**
     * top(): 스택의 맨 위 요소를 반환합니다 (제거하지 않음).
     * @return 스택의 맨 위 요소
     * @throws IllegalStateException 스택이 비어 있을 때 예외 발생
     */
    public int top() {
        if (stackList.isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot retrieve top element.");
        }
        return stackList.get(stackList.size() - 1);
    }

    /**
     * empty(): 스택이 비어 있는지 확인합니다.
     * @return 스택이 비어 있으면 true, 그렇지 않으면 false
     */
    public boolean empty() {
        return stackList.isEmpty();
    }

    /**
     * size(): 스택의 현재 크기를 반환합니다.
     * @return 스택에 있는 요소의 개수
     */
    public int size() {
        return stackList.size();
    }

    /**
     * peek(): 스택의 맨 위 요소를 확인합니다 (top()과 동일).
     * @return 스택의 맨 위 요소
     * @throws IllegalStateException 스택이 비어 있을 때 예외 발생
     */
    public int peek() {
        return top();
    }

    /**
     * display(): 스택의 모든 요소를 출력합니다.
     * 스택의 맨 위 요소부터 아래 요소까지 순서대로 출력합니다.
     */
    public void display() {
        if (stackList.isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("Stack elements: ");
        for (int i = stackList.size() - 1; i >= 0; i--) {
            System.out.println(stackList.get(i));
        }
    }
}