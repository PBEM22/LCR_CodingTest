import java.io.*;
import java.util.*;

public class Silver2_Q1012 {

    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};
    public static boolean[][] Node;
    public static boolean[][] visit;
    static int count;
    static int M, N, K;
    static int now_x, now_y;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (T > 0){

            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            Node = new boolean[N][M];
            visit = new boolean[N][M];

            while (K > 0){
                st = new StringTokenizer(br.readLine());

                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                Node[Y][X] = true;

                K--;
            }
            count = 0;
            for (int i = 0; i < N; i++){

                for (int j = 0; j < M; j++){

                    if (Node[i][j] && !visit[i][j]){
                        count++;
                        DFS(j, i);
                    }
                }
            }

            sb.append(count).append("\n");

            T--;
        }

        System.out.println(sb);

            // 순회하며 배추가 심어진 곳은 check , 상하좌우 +1씩 하며 체킹


    }

    public static void DFS(int x, int y) {
        visit[y][x] = true;

        for(int i=0; i<4; i++) {
            now_x = x + dirX[i];
            now_y = y + dirY[i];

            if(Range_check() && !visit[now_y][now_x] && Node[now_y][now_x]) {
                DFS(now_x, now_y);
            }

        }
    }

    static boolean Range_check() {
        return (now_y < N && now_y >= 0 && now_x < M && now_x >= 0);
    }
}

/**
 * 입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다. 그 다음 줄부터 각각의 테스트 케이스에 대해
 * 첫째 줄에는 배추를 심은 배추밭의 가로길이 M(1 ≤ M ≤ 50)과 세로길이 N(1 ≤ N ≤ 50),
 * 그리고 배추가 심어져 있는 위치의 개수 K(1 ≤ K ≤ 2500)이 주어진다.
 * 그 다음 K줄에는 배추의 위치 X(0 ≤ X ≤ M-1), Y(0 ≤ Y ≤ N-1)가 주어진다. 두 배추의 위치가 같은 경우는 없다.
 */
