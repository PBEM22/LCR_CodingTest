package boj;

import java.util.*;
import java.io.*;
public class Silver2_Q1260 {

    public static boolean[][] Node;
    public static boolean[] visit;

    static StringBuilder sb = new StringBuilder();

    static Queue<Integer> que = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        Node = new boolean[N+1][N+1];
        visit = new boolean[N+1];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            Node[A][B] = true;
            Node[B][A] = true;
        }

        sb.append(V).append(" ");
        DFS(V);
        System.out.println(sb);

        // 배열 초기화
        Arrays.fill(visit, false);

        sb = new StringBuilder();
        sb.append(V).append(" ");
        BFS(V);
        System.out.println(sb);
    }

    public static void DFS(int V){

        visit[V] = true;

        for(int i = 1; i < Node.length; i++){

            if (Node[V][i] && !visit[i]){
                visit[i] = true;
                sb.append(i).append(" ");

                DFS(i);
            }
        }

    }

    public static void BFS(int V){

        visit[V] = true;

        Queue<Integer> que = new LinkedList<>();

        for (int i = 1; i < Node.length; i++){

            if (Node[V][i] && !visit[i]){
                visit[i] = true;
                que.offer(i);
            }
        }

        while (!que.isEmpty()){
            Integer poll = que.poll();
            sb.append(poll).append(" ");

            for (int i = 1; i < Node.length; i++){
                if (Node[poll][i] && !visit[i]){
                    visit[i] = true;
                    que.offer(i);
                }
            }
        }


    }
}

/**
 * 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
 * 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고,
 * 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
 *
 * input: 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000),
 * 탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다.
 * 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.
 *
 * output: 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다.
 * V부터 방문된 점을 순서대로 출력하면 된다.
 */
