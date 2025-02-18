package boj;

import java.io.*;
import java.util.*;

// 수 정렬하기
public class Bronze2_Q2750 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int temp;
        int i = 1;

        if (N != 1){
            while (N > 0) {

                if (arr[i-1] > arr[i]){
                    temp = arr[i-1];
                    arr[i-1] = arr[i];
                    arr[i] = temp;
                }

                if (i >= N-1) {
                    i = 1;
                    N--;
                } else {
                    i++;
                }
            }
        }

        for (int k : arr) {
            System.out.println(k);
        }
    }
}
