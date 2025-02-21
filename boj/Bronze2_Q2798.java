package boj;

import java.util.*;
import java.io.*;

// 블랙잭
public class Bronze2_Q2798 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int result = 0;
        int temp = 0;

        boolean flag = false;

        outer:
        for (int i = 0; i < N-2; i++){

            for (int j = i+1; j < N-1; j++){

                for (int k = j+1; k < N; k++){

                    temp = arr[i] + arr[j] + arr[k];

                    if (M == temp){
                        System.out.println(temp);
                        flag = true;
                        break outer;
                    }

                    if (result < temp && temp < M){
                        result = temp;
                    }
                }
            }
        }

        if (!flag){
            System.out.println(result);
        }
    }
}
