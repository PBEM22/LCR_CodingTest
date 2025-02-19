package boj;

import java.io.*;
import java.util.*;

// 수 정렬하기 2
public class Silver5_Q2751 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        // 기본 오름차순
        Arrays.sort(A);

        for (int x : A){
            System.out.println(x);
        }
    }
}
