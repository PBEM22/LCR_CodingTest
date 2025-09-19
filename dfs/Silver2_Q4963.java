package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 정사각형으로 이루어져 있는 섬과 바다 지도가 주어진다. 섬의 개수를 세는 프로그램을 작성하시오.
 *
 *
 *
 * 한 정사각형과 가로, 세로 또는 대각선으로 연결되어 있는 사각형은 걸어갈 수 있는 사각형이다.
 *
 * 두 정사각형이 같은 섬에 있으려면, 한 정사각형에서 다른 정사각형으로 걸어서 갈 수 있는 경로가 있어야 한다.
 * 지도는 바다로 둘러싸여 있으며, 지도 밖으로 나갈 수 없다.
 */
public class Silver2_Q4963 {

    // 지도 크기
    static int[][] map;
    // 방문 체크
    static boolean[][] visited;

    // 섬 개수 카운트
    static int count = 0;

    // 위치 이동
    static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};

    static int w = 0;
    static int h = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());

            // 너비
            w = Integer.parseInt(st.nextToken());
            // 높이
            h = Integer.parseInt(st.nextToken());

            // 0 0을 만나면 종료
            if (w == 0 && h == 0){
                break;
            }

            // 지도 크기 생성
            map = new int[h][w];
            // 방문 체크 생성
            visited = new boolean[h][w];

            count = 0;

            for (int x = 0; x < h; x++) {
                st = new StringTokenizer(br.readLine());

                for (int y = 0; y < w; y++) {
                    map[x][y] = Integer.parseInt(st.nextToken());
                }
            }

            for (int x = 0; x < h; x++) {
                for (int y = 0; y < w; y++) {

                    if (!visited[x][y] && map[x][y] == 1){
                        dfs(x, y);
                        // 섬 개수 추가
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    // dfs
    public static void dfs(int x, int y){

        // 방문 체크
        visited[x][y] = true;

        for (int d = 0; d < 8; d++) {
            int newX = x + dx[d];
            int newY = y + dy[d];

            // newX와 newY가 범위를 벗어나는 경우 넘기기
            if (newX >= h || newX < 0 || newY >= w || newY < 0){
                continue;
            }

            // 방문 안했고, 섬인 경우 재귀함수
            if (!visited[newX][newY] && map[newX][newY] == 1){
                dfs(newX, newY);
            }

        }

    }
}
