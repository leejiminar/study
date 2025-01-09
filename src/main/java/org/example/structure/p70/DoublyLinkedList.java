package org.example.structure.p70;

class DoublyLinkedList {
    private DoublyNode head; // 리스트의 첫 번째 노드를 가리키는 참조 변수
    private DoublyNode tail; // 리스트의 마지막 노드를 가리키는 참조 변수

    // 연결 리스트 생성자: 빈 리스트로 초기화
    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    // 노드를 맨 끝에 추가
    public void append(int value) {
        DoublyNode newNode = new DoublyNode(value);

        // 리스트가 비어 있는 경우 head와 tail을 새 노드로 설정
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        // tail 뒤에 새 노드를 추가하고 tail을 업데이트
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // 노드를 특정 위치에 삽입
    public void insert(int value, int position) {
        DoublyNode newNode = new DoublyNode(value);

        // 삽입 위치가 0일 경우 head를 업데이트
        if (position == 0) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
            return;
        }

        DoublyNode current = head;
        // 삽입 위치의 직전 노드까지 이동
        for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        // 위치가 리스트 범위를 벗어난 경우 예외 처리
        if (current == null) {
            throw new IllegalArgumentException("Position out of bounds");
        }

        // 새 노드를 현재 노드와 다음 노드 사이에 삽입
        newNode.next = current.next;
        if (current.next != null) {
            current.next.prev = newNode;
        }
        current.next = newNode;
        newNode.prev = current;

        // tail이 업데이트될 경우 처리
        if (newNode.next == null) {
            tail = newNode;
        }
    }

    // 노드 삭제
    public void remove(int value) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        // head가 삭제 대상인 경우 처리
        if (head.data == value) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null; // 리스트가 비어 있는 경우 tail도 null로 설정
            }
            return;
        }

        DoublyNode current = head;
        // 삭제하려는 값을 가진 노드를 탐색
        while (current != null && current.data != value) {
            current = current.next;
        }

        // 삭제하려는 값이 리스트에 없는 경우 메시지 출력
        if (current == null) {
            System.out.println("Value not found in the list");
            return;
        }

        // 노드를 리스트에서 제거
        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev; // 삭제 대상이 tail인 경우 업데이트
        }
        if (current.prev != null) {
            current.prev.next = current.next;
        }
    }

    // 리스트 출력 (순방향)
    public void printList() {
        DoublyNode current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // 리스트 출력 (역방향)
    public void printReverse() {
        DoublyNode current = tail;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }
        System.out.println("null");
    }
}