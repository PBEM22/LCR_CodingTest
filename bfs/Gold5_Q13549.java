package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node{
    int position;
    int time;

    public Node(int position, int time) {
        this.position = position;
        this.time = time;
    }
}
public class Gold5_Q13549 {

    static int[] visited;

    static int N = 0;
    static int K = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 수빈이 현 위치
        N = Integer.parseInt(st.nextToken());

        // 동생 위치
        K = Integer.parseInt(st.nextToken());

        visited = new int[100001];
        Arrays.fill(visited, Integer.MAX_VALUE);

        System.out.println(bfs(N, 0));
    }

    // 현재 시간
    static int bfs(int position, int time){

        // 우선순위 큐
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.time));

        pq.add(new Node(position, time));
        visited[position] = time;

        while (!pq.isEmpty()){
            Node current = pq.poll();

            // 현재 위치가 동생 위치면 time 보내기
            if (current.position == K){
                return current.time;
            }

            if (current.time > visited[current.position]){
                continue;
            }

            int telPosition = current.position * 2;
            if (telPosition >= 0 && telPosition < 100001 && current.time < visited[telPosition]){
                // 시간 증가 x
                visited[telPosition] = current.time;
                pq.add(new Node(telPosition, current.time));
            }

            int plusPosition = current.position + 1;
            int plusTime = current.time + 1;
            if (plusPosition >= 0 && plusPosition < 100001 && plusTime < visited[plusPosition]){
                // 시간 증가 1
                visited[plusPosition] = plusTime;
                pq.add(new Node(plusPosition, plusTime));
            }

            int minusPosition = current.position -1;
            int minusTime = current.time+1;
            if (minusPosition >= 0 && minusPosition < 100001 && minusTime < visited[minusPosition]){
                // 시간 증가 1
                visited[minusPosition] = minusTime;
                pq.add(new Node(minusPosition, minusTime));
            }
        }

        return -1;
    }
}
