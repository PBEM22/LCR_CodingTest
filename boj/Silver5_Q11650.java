package boj;

import java.io.*;
import java.util.*;

// 좌표 정렬하기
public class Silver5_Q11650 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[][] A = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A, (o1, o2) -> {
            if (o1[0] == o2[0]){
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        for (int i = 0; i < N; i++) {
            sb.append(A[i][0]).append(" ").append(A[i][1]).append("\n");
        }

        System.out.println(sb);
    }
}
