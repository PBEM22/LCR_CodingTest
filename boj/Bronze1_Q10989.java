package boj;

import java.util.*;
import java.io.*;

// 수 정렬하기 3
public class Bronze1_Q10989 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        // 기본 오름차순
        Arrays.sort(A);

        for (int x : A){
            sb.append(x).append("\n");
        }

        System.out.println(sb);
    }
}
