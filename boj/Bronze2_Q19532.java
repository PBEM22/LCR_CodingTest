package boj;

import java.util.*;
import java.io.*;

// 수학은 비대면강의입니다
public class Bronze2_Q19532 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int a = array[0];
        int b = array[1];
        int c = array[2];
        int d = array[3];
        int e = array[4];
        int f = array[5];
//        int x = array[0] + array[3];
//        int y = array[1] + array[4];
//        int result = array[2] + array[5];

        outer:
        for (int i = -999; i <= 999; i++){

            for (int j = -999; j <= 999; j++){

                if (i * a + j * b == c){

                    if (i * d + j * e == f){
                        System.out.println(i + " " + j);
                        break outer;
                    }
                }
            }
        }
    }
}
