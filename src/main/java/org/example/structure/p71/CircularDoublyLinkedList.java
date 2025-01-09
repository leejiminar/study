package org.example.structure.p71;

class CircularDoublyLinkedList {
    private CircularDoublyNode head; // 리스트의 첫 번째 노드를 가리키는 참조 변수

    // 연결 리스트 생성자: 빈 리스트로 초기화
    public CircularDoublyLinkedList() {
        head = null;
    }

    // 노드를 맨 끝에 추가
    public void append(int value) {
        CircularDoublyNode newNode = new CircularDoublyNode(value);

        // 리스트가 비어 있는 경우 head를 새 노드로 설정하고 자신을 가리키게 설정
        if (head == null) {
            head = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
            return;
        }

        // 마지막 노드를 찾아 새 노드를 연결
        CircularDoublyNode tail = head.prev;
        tail.next = newNode;
        newNode.prev = tail;
        newNode.next = head;
        head.prev = newNode;
    }

    // 노드를 특정 위치에 삽입
    public void insert(int value, int position) {
        CircularDoublyNode newNode = new CircularDoublyNode(value);

        // 삽입 위치가 0일 경우 head를 업데이트
        if (position == 0) {
            if (head == null) {
                head = newNode;
                newNode.next = newNode;
                newNode.prev = newNode;
            } else {
                CircularDoublyNode tail = head.prev;
                newNode.next = head;
                newNode.prev = tail;
                tail.next = newNode;
                head.prev = newNode;
                head = newNode;
            }
            return;
        }

        CircularDoublyNode current = head;
        // 삽입 위치의 직전 노드까지 이동
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
            if (current == head) {
                throw new IllegalArgumentException("Position out of bounds");
            }
        }

        // 새 노드를 현재 노드와 다음 노드 사이에 삽입
        CircularDoublyNode nextNode = current.next;
        newNode.next = nextNode;
        newNode.prev = current;
        current.next = newNode;
        nextNode.prev = newNode;
    }

    // 노드 삭제
    public void remove(int value) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        CircularDoublyNode current = head;

        do {
            if (current.data == value) {
                // 노드가 하나뿐인 경우 처리
                if (current.next == current) {
                    head = null;
                    return;
                }

                // 삭제하려는 노드가 head인 경우 처리
                if (current == head) {
                    CircularDoublyNode tail = head.prev;
                    head = head.next;
                    tail.next = head;
                    head.prev = tail;
                } else {
                    // 중간 또는 마지막 노드 삭제
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                return;
            }
            current = current.next;
        } while (current != head);

        System.out.println("Value not found in the list");
    }

    // 리스트 출력 (순방향)
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        CircularDoublyNode current = head;
        do {
            System.out.print(current.data + " <-> ");
            current = current.next;
        } while (current != head);
        System.out.println("(back to head)");
    }

    // 리스트 출력 (역방향)
    public void printReverse() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        CircularDoublyNode tail = head.prev;
        CircularDoublyNode current = tail;
        do {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        } while (current != tail);
        System.out.println("(back to tail)");
    }
}