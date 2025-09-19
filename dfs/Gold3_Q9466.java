package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold3_Q9466 {

    static int[] std;
    static boolean[] visited;
    static boolean[] onPath; // 현재 탐색 중인 경로의 노드를 표시
    static int cycleCount = 0; // 팀을 이룬 학생 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            std = new int[n + 1];
            visited = new boolean[n + 1];
            onPath = new boolean[n + 1];
            cycleCount = 0;

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                std[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <= n; j++) {
                if (!visited[j]) {
                    dfs(j);
                }
            }

            sb.append(n - cycleCount).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int num) {
        visited[num] = true;
        onPath[num] = true; // 현재 경로에 포함

        int next = std[num];

        if (!visited[next]) {
            // 다음 학생을 아직 방문하지 않았으면 계속 탐색
            dfs(next);
        } else if (onPath[next]) {
            // 다음 학생이 현재 경로에 이미 있다면, 사이클 발생
            // 사이클의 길이를 세기
            cycleCount++;
            while (next != num) {
                next = std[next];
                cycleCount++;
            }
        }

        onPath[num] = false; // 현재 경로에서 제외 (백트래킹)
    }
}
