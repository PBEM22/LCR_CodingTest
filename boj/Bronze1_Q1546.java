package boj;

import java.io.*;
import java.util.*;

// 평균 구하기
public class Bronze1_Q1546 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int sum = 0;
        int top = 0;

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            top = Math.max(top, temp);
            sum += temp;
        }

        System.out.println((float)sum * 100 / top / N);
    }
}
