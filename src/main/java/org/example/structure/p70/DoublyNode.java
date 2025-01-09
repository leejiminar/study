package org.example.structure.p70;

class DoublyNode {
    int data; // 노드가 저장하는 데이터
    DoublyNode next; // 다음 노드를 가리키는 참조 변수
    DoublyNode prev; // 이전 노드를 가리키는 참조 변수

    // 노드 생성자: 값을 초기화하고 다음 및 이전 노드 참조를 null로 설정
    public DoublyNode(int value) {
        data = value;
        next = null;
        prev = null;
    }
}