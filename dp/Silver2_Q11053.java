package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 가장 긴 증가하는 부분 수열
public class Silver2_Q11053 {

    static int N;
    static int max;
    static int[] list;
    static int[] count;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

//        count = 1;
        st = new StringTokenizer(br.readLine(), " ");

        list = new int[N+1];
        count = new int[N+1];
        Arrays.fill(count, 1);
//        DP = new int[N+1];

        for (int i = 0; i < N; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++){
            max = list[i];

            for (int j = i; j < N; j++){
                if (max < list[j]){
                    max = list[j];
                    count[i]++;
                }
            }

            result = Math.max(count[i], result);

        }

        System.out.println(result);

    }



}
