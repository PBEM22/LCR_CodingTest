package stack;

import java.io.*;
import java.util.*;

// 스택 수열
public class Silver2_Q1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        int count = 1;
        int temp = 0;

        for (int i = 1; i <= N; i++){


            if (arr[i-1] >= count){
                while (arr[i-1] >= count){
                    stack.push(count++);
                    sb.append("+\n");
                }

                stack.pop();
                sb.append("-\n");
            } else {
                temp = stack.pop();
                if (temp > arr[i-1]){
                    sb.setLength(0);
                    sb.append("NO");
                    break;
                } else {
                    sb.append("-\n");
                }
            }
        }

        System.out.println(sb);
    }
}
