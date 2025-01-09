package org.example.structure.p58_68;

// 연결 리스트를 나타내는 클래스 정의
class LinkedList {
    private Node head; // 리스트의 첫 번째 노드를 가리키는 참조 변수

    // 연결 리스트 생성자: 빈 리스트로 초기화
    public LinkedList() {
        head = null; // 리스트 초기 상태: 비어 있음
    }

    // PDF 60p
    // 노드를 리스트의 맨 끝에 추가하는 메서드
    public void append(int value) {
        // 리스트가 비어 있는 경우
        if (head == null) {
            head = new Node(value); // 새 노드를 head로 설정
            return;
        }

        // 리스트 끝까지 이동하여 노드 추가
        Node current = head; // 현재 노드부터 시작
        while (current.next != null) { // 마지막 노드까지 이동
            current = current.next;
        }
        current.next = new Node(value); // 새 노드를 리스트 끝에 연결
    }

    // PDF 63p
    // 특정 위치에 노드를 삽입하는 메서드
    public void insert(int value, int position) {
        Node newNode = new Node(value); // 새 노드 생성

        // 삽입 위치가 0이면, 새 노드를 head로 설정
        if (position == 0) {
            newNode.next = head; // 기존 head를 새 노드의 다음 노드로 설정
            head = newNode; // 새 노드를 head로 변경
            return;
        }

        Node current = head; // 현재 노드부터 시작
        // 삽입 위치 직전까지 이동
        for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        // PDF 63p 없는 내용 추가
        // 삽입 위치가 범위를 벗어나면 예외 발생
        if (current == null) {
            throw new IllegalArgumentException("Position out of bounds");
        }

        // 새 노드를 현재 노드와 다음 노드 사이에 삽입
        newNode.next = current.next; // 새 노드가 기존 다음 노드를 가리킴
        current.next = newNode; // 현재 노드가 새 노드를 가리키도록 설정
    }

    // PDF 68p
    // 특정 값을 가진 노드를 삭제하는 메서드
    public void remove(int value) {
        // PDF 68p 없는 내용 추가
        // 리스트가 비어 있는 경우
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        // 삭제하려는 값이 첫 번째 노드에 있는 경우
        if (head.data == value) {
            head = head.next; // head를 다음 노드로 변경
            return;
        }

        Node current = head; // 현재 노드부터 시작
        // 삭제하려는 값을 가진 노드 직전까지 이동
        while (current.next != null && current.next.data != value) {
            current = current.next;
        }

        // PDF 68p 없는 내용 추가
        // 삭제하려는 값이 리스트에 없는 경우
        if (current.next == null) {
            System.out.println("Value not found in the list");
            return;
        }

        // 노드 삭제: 현재 노드의 다음 노드를 건너뜀
        current.next = current.next.next;
    }

    // 리스트를 출력하는 메서드
    public void printList() {
        Node current = head; // 리스트의 첫 번째 노드부터 시작
        while (current != null) {
            System.out.print(current.data + " -> "); // 현재 노드 데이터 출력
            current = current.next; // 다음 노드로 이동
        }
        System.out.println("null"); // 리스트의 끝 표시
    }

    // 리스트의 길이를 반환하는 메서드
    public int size() {
        int count = 0; // 노드 개수를 저장하는 변수
        Node current = head; // 리스트의 첫 번째 노드부터 시작
        while (current != null) {
            count++; // 노드 개수 증가
            current = current.next; // 다음 노드로 이동
        }
        return count; // 총 노드 개수 반환
    }
}