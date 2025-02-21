package boj;

import java.util.*;
import java.io.*;

// 덱 2
public class Silver4_Q28279 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> deque = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {

            String[] charArray = br.readLine().split(" ");

            int order = Integer.parseInt(charArray[0]);

            switch (order){
                case 1:
                    deque.addFirst(Integer.parseInt(charArray[1]));
                    break;
                case 2:
                    deque.addLast(Integer.parseInt(charArray[1]));
                    break;
                case 3:
                    if (!deque.isEmpty()){
                        sb.append(deque.removeFirst()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;
                case 4:
                    if (!deque.isEmpty()){
                        sb.append(deque.removeLast()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;
                case 5:
                    sb.append(deque.size()).append("\n");
                    break;
                case 6:
                    if (deque.isEmpty()){
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case 7:
                    if (!deque.isEmpty()){
                        sb.append(deque.getFirst()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;
                case 8:
                    if (!deque.isEmpty()){
                        sb.append(deque.getLast()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;
                default:
                    break;
            }
        }

        System.out.println(sb);
    }
}
