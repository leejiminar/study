package org.example.dfs_bfs.p145_146;

// 문제: 너비 우선 탐색(BFS)을 사용하여 트리 구조 탐색
// 인접 리스트로 표현된 그래프: 𝑂(𝑉 + 𝐸)

import java.util.*;

public class BFSGraph {
    // 그래프를 인접 리스트로 표현
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited; // 방문 여부를 체크하는 배열

    public static void main(String[] args) {
        // 1. 그래프 초기화 (1-based indexing)
        int numberOfNodes = 10; // 노드의 개수
        visited = new boolean[numberOfNodes + 1]; // 방문 배열

        // 인접 리스트 초기화
        for (int i = 0; i <= numberOfNodes; i++) {
            graph.add(new ArrayList<>());
        }

        // 2. 그래프에 간선 추가 (주어진 트리 구조에 맞게 연결)
        addEdge(1, 2);
        addEdge(1, 3);
        addEdge(1, 4);
        addEdge(2, 5);
        addEdge(3, 6);
        addEdge(3, 7);
        addEdge(4, 8);
        addEdge(5, 9);
        addEdge(6, 10);

        // 3. BFS 탐색 시작
        System.out.println("BFS 결과:");
        bfs(1); // 시작(root - 1번) 노드부터 탐색 시작
    }

    // 간선을 추가하는 메서드
    static void addEdge(int from, int to) {
        graph.get(from).add(to); // 방향 그래프가 아니라 무방향 그래프라면
        graph.get(to).add(from); // 무방향 그래프이므로 양방향 간선 추가 (필요한 경우)
    }

    // BFS 메서드
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>(); // BFS를 위한 큐 생성
        queue.add(start); // 시작 노드를 큐에 추가
        visited[start] = true; // 시작 노드를 방문 처리

        while (!queue.isEmpty()) {
            int now = queue.poll(); // 큐에서 현재 노드 꺼내기
            System.out.print(now + " "); // 방문한 노드 출력

            // 현재 노드에 연결된 다음 노드를 큐에 추가
            for (int next : graph.get(now)) {
                if (!visited[next]) { // 방문하지 않은 노드만 추가
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}