package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver4_Q1015 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] B = new int[N];
        int num;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            A[i] = num;
            B[i] = num;
        }

        Arrays.sort(B);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i] == B[j]) {
                    sb.append(j);
                    B[j] = -1;
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
