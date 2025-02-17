package boj;

import java.util.*;
import java.io.*;

// 구간 합 구하기 4
public class Silver3_Q11659 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        long[] S = new long[N+1];
        int[] A = new int[N+1];

        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());

            if (i == 1){
                S[i] = A[i];
            } else {
                S[i] = S[i -1] + A[i];
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            if (first == 1){
                sb.append(S[second]).append("\n");
            } else if (first == second){
                sb.append(A[first]).append("\n");
            } else {
                sb.append(S[second] - S[first - 1]).append("\n");
            }
        }
        System.out.println(sb);
    }
}
