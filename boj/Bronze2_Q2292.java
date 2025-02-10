package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 벌집
public class Bronze2_Q2292 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 1;
        int range = 2;

        if (N == 1){
            System.out.println(N);
        } else {
            while (range <= N){

                range += 6 * count;
                count++;
            }
            System.out.println(count);
        }


    }
}
