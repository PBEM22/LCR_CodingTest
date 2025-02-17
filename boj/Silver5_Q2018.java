package boj;

import java.io.*;
import java.util.*;

// 수들의 합 5
public class Silver5_Q2018 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int startIndex = 1;
        int endIndex = 1;

        int sum = 1;
        int count = 1;

        while (endIndex != N) {

            if (sum == N) {
                endIndex++;
                count++;
                sum += endIndex;
            } else if (sum < N) {
                endIndex++;
                sum += endIndex;
            } else {
                sum -= startIndex;
                startIndex++;
            }
        }

        System.out.println(count);
    }

}
