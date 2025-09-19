package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Gold1_Q13460 {

    // 좌표
    static int N, M;
    static char[][] board;
    static boolean[][][][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 세로
        N = Integer.parseInt(st.nextToken());
        // 가로
        M = Integer.parseInt(st.nextToken());

        // 방문
        visit = new boolean[N][M][N][M];

        // 전체
        board = new char[N][M];

        // R의 좌표
        int rx = 0, ry = 0;
        // B의 좌표
        int bx = 0, by = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'R') {
                    rx = i;
                    ry = j;
                } else if (board[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }

        System.out.println(bfs(rx, ry, bx, by));
    }

    // BFS
    private static int bfs(int rx, int ry, int bx, int by) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{rx, ry, bx, by, 0}); // 0은 이동횟수
        visit[rx][ry][bx][by] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            // 현재 이동 횟수
            int count = now[4];

            // 10번 넘으면 실패
            if (count >= 10) {
                return -1;
            }

            for (int i = 0; i < 4; i++) {
                int nrx = now[0];
                int nry = now[1];
                int nbx = now[2];
                int nby = now[3];

                // 파란 구슬 먼저 굴리기 (벽 또는 구멍에 멈출 때까지)
                while (board[nbx + dx[i]][nby + dy[i]] != '#') {
                    nbx += dx[i];
                    nby += dy[i];
                    if (board[nbx][nby] == 'O') break; // 구멍에 빠졌다면 멈춤
                }

                // 빨간 구슬 굴리기 (벽 또는 구멍에 멈출 때까지)
                while (board[nrx + dx[i]][nry + dy[i]] != '#') {
                    nrx += dx[i];
                    nry += dy[i];
                    if (board[nrx][nry] == 'O') break; // 구멍에 빠졌다면 멈춤
                }


                // 파란 구슬이 빠지면 실패
                if (board[nbx][nby] == 'O'){
                    continue;
                }

                // 빨간 구슬이 빠지면 성공
                if (board[nrx][nry] == 'O'){
                    return count + 1;
                }

                // 두 구슬이 겹치는 경우 위치 조절
                if (nrx == nbx && nry == nby) {
                    if (i == 0){    // 상 (x가 -1)
                        if (now[0] > now[2]) {
                            nrx++;
                        } else {
                            nbx++;
                        }
                    } else if (i == 1) {    // 하 (x가 1)
                        if (now[0] < now[2]) {
                            nrx--;
                        } else {
                            nbx--;
                        }
                    } else if (i == 2) {    // 좌 (y가 -1)
                        if (now[1] > now[3]){
                            nry++;
                        } else {
                            nby++;
                        }
                    } else {    // 우 (y가 1)
                        if (now[1] < now[3]){
                            nry--;
                        } else {
                            nby--;
                        }
                    }
                }

                // 방문 안했으면 큐에 추가
                if (!visit[nrx][nry][nbx][nby]){
                    visit[nrx][nry][nbx][nby] = true;
                    // 카운트도 +1
                    queue.add(new int[]{nrx, nry, nbx, nby, count + 1});
                }
            }
        }

        return -1;
    }
}
