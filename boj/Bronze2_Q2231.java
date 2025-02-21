package boj;

import java.io.*;
import java.util.*;

// 분해합
public class Bronze2_Q2231 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int N = Integer.parseInt(s);

        int result = 0;

        for (int i = N - (s.length() * 9); i < N; i++) {

            int number = i;
            int sum = 0;

            while (number != 0) {
                sum += number % 10;
                number /= 10;
            }

            if (sum + i == N){
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
}
