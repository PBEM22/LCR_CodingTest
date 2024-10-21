package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 전쟁 - 전투
 *
 * Q.
 * 전쟁은 어느덧 전면전이 시작되었다. 결국 전투는 난전이 되었고, 우리 병사와 적국 병사가 섞여 싸우게 되었다.
 * 그러나 당신의 병사들은 흰색 옷을 입고, 적국의 병사들은 파란색 옷을 입었기 때문에 서로가 적인지 아군인지는 구분할 수 있다.
 * 문제는 같은 팀의 병사들은 모이면 모일수록 강해진다는 사실이다.
 *
 * N명이 뭉쳐있을 때는 N2의 위력을 낼 수 있다. 과연 지금 난전의 상황에서는 누가 승리할 것인가?
 * 단, 같은 팀의 병사들이 대각선으로만 인접한 경우는 뭉쳐 있다고 보지 않는다.
 *
 * Input.
 * 첫째 줄에는 전쟁터의 가로 크기 N, 세로 크기 M(1 ≤ N, M ≤ 100)이 주어진다.
 * 그 다음 두 번째 줄에서 M+1번째 줄에는 각각 (X, Y)에 있는 병사들의 옷색이 띄어쓰기 없이 주어진다.
 * 모든 자리에는 병사가 한 명 있다. B는 파란색, W는 흰색이다. 당신의 병사와 적국의 병사는 한 명 이상 존재한다.
 *
 * Output.
 * 첫 번째 줄에 당신의 병사의 위력의 합과 적국의 병사의 위력의 합을 출력한다.
 */

public class Silver1_Q1303 {

    static boolean[][] visits;
    static char[][] solution;
    static int white, blue;
    static int N, M;
    static int[] dirX = {-1, 1, 0, 0};
    static int[] dirY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 가로 크기
        N = Integer.parseInt(st.nextToken());

        // 세로 크기
        M = Integer.parseInt(st.nextToken());

        visits = new boolean[M+1][N+1];
        solution = new char[M+1][N+1];

        for (int i = 1; i <= M; i++) {
            // 라인 읽고
            String line = br.readLine();
            char[] charArray = line.toCharArray();

            // char 2차원 배열에 담기
            for (int j = 0; j < line.length(); j++) {
                solution[i][j+1] = charArray[j];
            }
        }

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {

                if (!visits[i][j]) {
                    BFS(i, j);
                }
            }
        }

        System.out.println(white + " " + blue);
    }

    // BFS 방식
    static void BFS(int start, int end) {
        int count = 1;

        Queue<int[]> que = new LinkedList<>();
        visits[start][end] = true;
        que.add(new int[]{start, end});
        while (!que.isEmpty()) {

            int[] pol = que.poll();
            int nowX = pol[0], nowY = pol[1];

            for (int i = 0; i < 4; i++) {
                int newX = nowX + dirX[i];
                int newY = nowY + dirY[i];

                if (newX < 1 || newX > N || newY < 1 || newY > M) continue;
                if (!visits[newX][newY] && solution[nowX][nowY] == solution[newX][newY]) {
                    visits[newX][newY] = true;
                    que.add(new int[]{newX, newY});
                    count++;
                }
            }

        }

        if (solution[start][end] == 'W') {white += (count * count);}
        if (solution[start][end] == 'B') {blue += (count * count);}
    }


}
