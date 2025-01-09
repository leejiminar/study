package org.example.structure.p80_87;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Java Queue Implementation
 * 주요 연산: enqueue, dequeue, front, empty, size, add, peek, poll
 * 큐는 FIFO (First In First Out) 방식으로 동작하는 자료구조입니다.
 */
public class JavaQueueExample {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(); // Queue 생성

        /**
         * enqueue (add): 큐에 요소를 추가합니다.
         * offer()는 큐의 끝에 요소를 추가하며, 공간 부족 시 예외를 발생시키지 않습니다.
         */
        queue.add(10); // 10 추가
        queue.add(20); // 20 추가
        queue.add(30); // 30 추가
        System.out.println("Queue after enqueue operations: " + queue);

        /**
         * front (peek): 큐의 맨 앞 요소를 반환합니다 (제거하지 않음).
         */
        System.out.println("Front element (peek): " + queue.peek());

        /**
         * dequeue (poll): 큐의 맨 앞 요소를 제거하고 반환합니다.
         * 만약 큐가 비어 있으면 poll()은 null을 반환하고 remove()는 예외를 발생시킵니다.
         */
        System.out.println("Dequeued element: " + queue.poll());
        System.out.println("Queue after dequeue operation: " + queue);

        /**
         * size: 큐에 있는 요소의 개수를 반환합니다.
         */
        System.out.println("Queue size: " + queue.size());

        /**
         * empty: 큐가 비어 있는지 확인합니다.
         */
        System.out.println("Is queue empty? " + queue.isEmpty());

        /**
         * 추가 메서드
         * add: 큐의 끝에 요소를 추가하며, 공간 부족 시 예외를 발생시킵니다.
         */
        queue.add(40);
        queue.add(50);
        System.out.println("Queue after adding elements: " + queue);

        /**
         * poll: 큐의 맨 앞 요소를 제거하고 반환합니다. 비어 있으면 null 반환.
         */
        System.out.println("Polled element: " + queue.poll());
        System.out.println("Queue after polling: " + queue);

        /**
         * peek: 큐의 맨 앞 요소를 확인합니다 (제거하지 않음).
         */
        System.out.println("Peek element: " + queue.peek());

        /**
         * 반복문을 사용하여 큐의 요소를 출력합니다.
         */
        System.out.println("Iterating through the queue:");
        for (int element : queue) {
            System.out.println(element);
        }

        /**
         * 전체 큐 비우기 (clear)
         */
        queue.clear();
        System.out.println("Queue after clearing: " + queue);
        System.out.println("Is queue empty after clearing? " + queue.isEmpty());
    }
}
