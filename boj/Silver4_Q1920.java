package boj;

import java.util.*;
import java.io.*;

// 수 찾기
public class Silver4_Q1920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        int[] Marr = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            Marr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);


        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Marr.length; i++) {


            boolean flag = false;
            int start = 0;
            int end = A.length - 1;

            while (start <= end) {

                int center = (start + end) / 2;
                int value = A[center];

                if (Marr[i] > value){
                    start = center + 1;
                } else if (Marr[i] < value) {
                    end = center - 1;
                } else {
                    flag = true;
                    break;
                }
            }

            if (flag){
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }

        System.out.println(sb);
    }
}
