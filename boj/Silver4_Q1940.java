package boj;

import java.io.*;
import java.util.*;

// 주몽
public class Silver4_Q1940 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int count = 0;

        int start = 0;
        int end = arr.length - 1;
        int sum = arr[start] + arr[end];

        while (end > start){

            if (sum == M){
                count++;
                start++;
                end--;
                sum = arr[start] + arr[end];

            } else if (sum > M) {
                end--;
                sum = arr[start] + arr[end];
            } else {
                start++;
                sum = arr[start] + arr[end];
            }
        }

        System.out.println(count);
    }
}
