package dp;

import java.util.*;
import java.io.*;

// 정수 삼각형
public class Silver1_Q1932 {

    static Integer[][] DP;
    static int[][] Value;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        DP = new Integer[N+1][N+1];
        Value = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= i; j++) {
                Value[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DP[1][1] = Value[1][1];

        int result = 0;

        if (N == 1){
            result = DP[1][1];
        } else {
            for (int i = 2; i <= N; i++) {
                int temp = Math.max(solve(N, i-1), solve(N, i));

                result = Math.max(result, temp);
            }
        }

        System.out.println(result);
    }

    static int solve(int N, int M){

        if (DP[N][M] == null) {
            if (M == 1) {
                DP[N][M] = solve(N-1, M) + Value[N][M];
            } else if (M == N) {
                DP[N][M] = solve(N-1, M-1) + Value[N][M];
            } else {
                DP[N][M] = Math.max(solve(N-1, M-1), solve(N-1, M)) + Value[N][M];
            }
        }

        return DP[N][M];
    }
}
