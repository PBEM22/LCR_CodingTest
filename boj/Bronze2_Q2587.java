package boj;

import java.util.*;
import java.io.*;

// 대표값2
public class Bronze2_Q2587 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] A = new int[5];
        int sum = 0;
        for (int i = 0; i < 5; i++){
            A[i] = Integer.parseInt(br.readLine());
            sum += A[i];
        }

        int avg = sum / A.length;
        int temp = 0;
        for (int i = 0; i < 5; i++){

            for (int j = 0; j < 4 - i; j++){
                if (A[j] > A[j+1]){
                    temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                }
            }
        }

        System.out.println(avg);
        System.out.println(A[2]);
    }
}
