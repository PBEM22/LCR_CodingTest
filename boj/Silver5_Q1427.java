package boj;

import java.util.*;
import java.io.*;

// 소트인사이드
public class Silver5_Q1427 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        int[] A = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            A[i] = str.charAt(i) - '0';
        }

        for (int i = 0; i < str.length(); i++) {
            int max = i;
            for (int j = i + 1; j < str.length(); j++) {
                if (A[j] > A[max]) {
                    max = j;
                }
            }
            if (A[i] < A[max]) {
                int temp = A[i];
                A[i] = A[max];
                A[max] = temp;
            }
        }

        for(int i = 0; i < A.length; i++){
            sb.append(A[i]);
        }

        System.out.println(sb);
    }
}
