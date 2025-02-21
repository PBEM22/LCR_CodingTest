package boj;

import java.io.*;
import java.util.*;

// 체스판 다시 칠하기
public class Silver4_Q1018 {

    static char[][] board;
    static int min = 64;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 보드판
        board = new char[N][M];

        for (int i = 0; i < N; i++) {

            String str = br.readLine();

            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N - 7; i++) {

            for (int j = 0; j < M - 7; j++) {

                solve(i, j);
            }
        }

        System.out.println(min);
    }

    public static void solve(int x, int y){
        int endX = x + 7;
        int endY = y + 7;
        int count = 0;

        boolean TF = board[x][y] == 'B';

        for (int i = x; i <= endX; i++) {

            for (int j = y; j <= endY; j++) {

                if (board[i][j] != (TF ? 'B' : 'W')) {
                    count++;
                }

                TF = !TF;
            }

            TF = !TF;
        }

        count = Math.min(count, 64 - count);

        min = Math.min(min, count);
    }
}
