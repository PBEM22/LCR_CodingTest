package bfs;

import java.util.*;
import java.io.*;

// 숨바꼭질
public class Silver1_Q1697 {

    static int N, K;
    static int[] visit = new int[100001];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(BFS(N));
    }

    static int BFS(int n){

        Queue<Integer> que = new LinkedList<>();

        que.add(n);
        int now;
        visit[n] = 1;
        while (!que.isEmpty()){

            now = que.poll();

            if (now == K){
                return visit[now]-1;
            }

            if (now - 1 >= 0 && visit[now-1] == 0){
                visit[now-1] = visit[now] + 1;
                que.add(now-1);
            }
            if (now + 1 <= 100000 && visit[now+1] == 0){
                visit[now+1] = visit[now] + 1;
                que.add(now+1);
            }
            if (now * 2 <= 100000 && visit[now*2] == 0){
                visit[now*2] = visit[now] + 1;
                que.add(now*2);
            }
        }

        return 0;
    }
}
