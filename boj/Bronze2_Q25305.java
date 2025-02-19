package boj;

import java.util.*;
import java.io.*;

// 커트라인
public class Bronze2_Q25305 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] x = new int[N+1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++){
            x[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++){

            for (int j = 1; j <= N - i; j++){

                if (x[j] < x[j+1]){
                    int temp = x[j];
                    x[j] = x[j+1];
                    x[j+1] = temp;
                }
            }
        }

        System.out.println(x[k]);



    }
}
