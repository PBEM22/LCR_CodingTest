package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Node{
    // 정점, 다음 노드, 다음 노드와의 거리
    int vertex, nextNode, edge;

    public Node(int vertex, int i, int i1) {
        this.vertex = vertex;
        this.nextNode = i;
        this.edge = i1;
    }

}

public class Gold2_Q1167 {
    static List<Node>[] nodes;
    static int max = 0;
    static int V = 0;
    static boolean[] visited;
    static int farNode = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 트리의 정점 개수
        V = Integer.parseInt(br.readLine());

        // 노드 초기화
        nodes = new List[V+1];
        for (int i = 1; i <= V; i++){
            nodes[i] = new ArrayList<>();
        }

        // 방문 배열
        visited = new boolean[V+1];

        // 정점
        int vertex = 0;

        for (int i = 1; i <= V; i++) {
            String[] line = br.readLine().split(" ");

            // 주어진 정점
            vertex = Integer.parseInt(line[0]);

            // 인접 노드 기록
            for (int j = 1; j < line.length-1; j += 2){
                nodes[vertex].add(new Node(vertex, Integer.parseInt(line[j]), Integer.parseInt(line[j+1])));
            }
        }

        // 첫번째 dfs (첫번째 노드와 가장 먼 노드 찾기)
        dfs(1, 0);

        // 방문 배열 초기화
        Arrays.fill(visited, false);

        // 가장 먼 노드로 해답 찾기
        dfs(farNode, 0);

        System.out.println(max);
    }

    static void dfs(int currentNode, int depth){

        // 방문처리
        visited[currentNode] = true;

        // max값 초기화
        if (depth > max){
            max = depth;
            farNode = currentNode;
        }

        // 재귀함수
        for (int i = 0; i < nodes[currentNode].size(); i++) {
            if (!visited[nodes[currentNode].get(i).nextNode]){
                dfs(nodes[currentNode].get(i).nextNode, nodes[currentNode].get(i).edge + depth);
            }
        }

    }
}
