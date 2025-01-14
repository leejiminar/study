package org.example.dfs_bfs.p138_139;

// p138_139.DFSGraph = p141.DFSGraph
// 문제: 주어진 트리 구조에 대해 깊이 우선 탐색(DFS) 수행
// 인접 리스트로 표현된 그래프: 𝑂(𝑉 + 𝐸)

import java.util.ArrayList;
import java.util.List;

public class DFSGraph {
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
        addEdge(1, 5);
        addEdge(1, 9);
        addEdge(2, 3);
        addEdge(3, 4);
        addEdge(5, 6);
        addEdge(5, 8);
        addEdge(6, 7);
        addEdge(9, 10);

        // 3. DFS 탐색 시작
        System.out.println("DFS 탐색 결과:");
        dfs(1); // 시작(root - 1번) 노드부터 탐색 시작
    }

    // 간선을 추가하는 메서드
    static void addEdge(int from, int to) {
        graph.get(from).add(to); // 방향 그래프가 아니라 무방향 그래프라면
        graph.get(to).add(from); // 무방향 그래프이므로 양방향 간선 추가 (필요한 경우)
    }

    // DFS 알고리즘 구현 메서드
    static void dfs(int now) {
        visited[now] = true; // 현재 노드를 방문 처리
        System.out.print(now + " "); // 방문한(현재) 노드 출력

        // 현재 노드에 연결된 다음 노드를 재귀적으로 방문
        for (int next : graph.get(now)) {
            if (!visited[next]) { // 방문하지 않은 노드라면
                dfs(next);        // 재귀 호출
            }
        }
    }
}