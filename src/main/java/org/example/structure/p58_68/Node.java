package org.example.structure.p58_68;

// PDF 58p
// Node 클래스는 연결 리스트의 각 요소를 나타냄
class Node {
    int data; // 노드가 저장하는 데이터
    Node next; // 다음 노드를 가리키는 참조 변수

    // 노드 생성자: 데이터 초기화
    public Node(int value) {
        data = value;
        next = null; // 다음 노드는 초기 상태에서 null
    }
}