package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver1_Q2178 {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] map;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // map 배열을 [N][M] 크기로 선언
        map = new int[N][M];

        // 입력 처리: 0부터 N-1, 0부터 M-1 인덱스에 맞게 데이터를 저장
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        // BFS를 시작하고, 결과는 도착점의 값으로 판단
        bfs(0, 0);

        // 도착 위치(N-1, M-1)에 저장된 값(최단 거리) 출력
        System.out.println(map[N - 1][M - 1]);
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        // 시작점의 거리는 1
        map[x][y] = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentCount = map[current[0]][current[1]];

            for (int i = 0; i < 4; i++) {
                int newX = current[0] + dx[i];
                int newY = current[1] + dy[i];

                // 1. 새로운 좌표가 미로의 범위를 벗어나는지 확인
                if (newX < 0 || newX >= N || newY < 0 || newY >= M) {
                    continue;
                }

                // 2. 이동 가능한 칸(1)이고 아직 방문하지 않은 칸인지 확인
                // map[newX][newY] == 1 이면 아직 방문하지 않았다는 뜻
                if (map[newX][newY] == 1) {
                    // 방문 표시와 함께 최단 거리 갱신
                    map[newX][newY] = currentCount + 1;
                    queue.add(new int[]{newX, newY});
                }
            }
        }
    }
}