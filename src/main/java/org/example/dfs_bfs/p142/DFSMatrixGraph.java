package org.example.dfs_bfs.p142;

// 문제: 행렬로 그래프를 표현하고 DFS(깊이 우선 탐색) 수행
// 행렬로 표현된 그래프: 𝑂(𝑉^2)

public class DFSMatrixGraph {
    // 그래프를 행렬로 표현
    static int[][] graph;
    static boolean[] visited; // 노드 방문 여부를 기록

    public static void main(String[] args) {
        // 1. 그래프 초기화 (1-based indexing)
        int numberOfNodes = 4; // 노드 개수
        graph = new int[numberOfNodes + 1][numberOfNodes + 1];
        visited = new boolean[numberOfNodes + 1];

        // 2. 간선 추가
        addEdge(1, 2);
        addEdge(1, 3);
        addEdge(2, 3);
        addEdge(2, 4);
        addEdge(4, 3);

        // 3. DFS 수행
        System.out.println("DFS 결과:");
        dfs(1); // 1번 노드부터 탐색 시작
    }

    // 간선 추가 메서드
    static void addEdge(int from, int to) {
        graph[from][to] = 1; // (from, to) 간선 존재를 1로 표시
    }

    // DFS 메서드
    static void dfs(int now) {
        visited[now] = true; // 현재 노드 방문 처리
        System.out.print(now + " "); // 방문한 노드 출력

        // 현재 노드에서 갈 수 있는 노드 탐색
        for (int next = 1; next < graph.length; next++) {
            if (graph[now][next] == 1 && !visited[next]) {
                dfs(next); // 방문하지 않은 노드로 이동
            }
        }
    }
}
