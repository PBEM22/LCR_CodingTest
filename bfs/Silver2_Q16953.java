package bfs;

import java.util.*;
import java.io.*;

// A -> B
public class Silver2_Q16953 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split("\\s");

        int A = Integer.parseInt(arr[0]);
        int B = Integer.parseInt(arr[1]);

        System.out.println(BFS(A, B));
    }

    static int BFS(int A, int B) {

        Queue<Long> q = new LinkedList<>();
        int result = 0;

        q.add((long)A);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++){
                long temp = q.poll();
                if (temp == B){
                    return ++result;
                }

                if (temp*2 <= B) q.add(temp*2);
                if (temp*10+1 <= B) q.add(temp*10+1);
            }

            result++;
        }

        return -1;
    }
}
