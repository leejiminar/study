package org.example.structure.p70;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList(); // 이중 연결 리스트 생성

        // 노드 추가
        list.append(10); // 값 10 추가
        list.append(20); // 값 20 추가
        list.append(30); // 값 30 추가

        // 리스트 출력
        System.out.print("List (forward)                             : ");
        list.printList();

        // 리스트 역방향 출력
        System.out.print("List (reverse)                             : ");
        list.printReverse();

        // 노드 삽입
        list.insert(15, 1); // 값 15를 위치 1에 삽입
        System.out.print("After inserting 15 at position 1 (forward) : ");
        list.printList();

        // 노드 삭제
        list.remove(20); // 값 20을 가진 노드 삭제
        System.out.print("After removing 20 (forward)                : ");
        list.printList();

        // 리스트 역방향 출력
        System.out.print("List (reverse)                             : ");
        list.printReverse();
    }
}