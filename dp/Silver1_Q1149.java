package dp;

// RGB 거리

import java.io.*;
import java.util.StringTokenizer;

public class Silver1_Q1149 {

    // N번까지의 선택의 합 저장
    static Integer[][] DP;

    // N번과 N-1의 선택값 저장
    static int[][] Cost;

    // 명시
    static int Red = 0;
    static int Green = 1;
    static int Blue = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        DP = new Integer[N][3];
        Cost = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Cost[i][Red] = Integer.parseInt(st.nextToken());
            Cost[i][Green] = Integer.parseInt(st.nextToken());
            Cost[i][Blue] = Integer.parseInt(st.nextToken());
        }

        DP[0][Red] = Cost[0][Red];
        DP[0][Green] = Cost[0][Green];
        DP[0][Blue] = Cost[0][Blue];

        System.out.println(Math.min(solve(N-1, Red), Math.min(solve(N-1, Green), solve(N-1, Blue))));
    }

    static int solve(int N, int color) {

        if (DP[N][color] == null || DP[N][color] == 0) {

            if (color == Red){
                DP[N][Red] = Math.min(solve(N-1, Green), solve(N-1, Blue)) + Cost[N][Red];
            } else if (color == Green){
                DP[N][Green] = Math.min(solve(N-1, Red), solve(N-1, Blue)) + Cost[N][Green];
            } else {
                DP[N][Blue] = Math.min(solve(N-1, Red), solve(N-1, Green)) + Cost[N][Blue];
            }
        }
            return DP[N][color];
    }
}
