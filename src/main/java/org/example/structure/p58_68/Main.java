package org.example.structure.p58_68;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList(); // 연결 리스트 생성

        // 노드 추가
        list.append(10); // 값 10 추가
        list.append(20); // 값 20 추가
        list.append(30); // 값 30 추가

        // 리스트 출력
        System.out.print("Initial list                     : ");
        list.printList();

        // 노드 삽입
        list.insert(15, 1); // 값 15를 위치 1에 삽입
        System.out.print("After inserting 15 at position 1 : ");
        list.printList();

        // 노드 삭제
        list.remove(20); // 값 20을 가진 노드 삭제
        System.out.print("After removing 20                : ");
        list.printList();

        // 리스트 크기 확인
        System.out.println("Size of the list                 : " + list.size()); // 리스트의 총 길이 출력
    }
}