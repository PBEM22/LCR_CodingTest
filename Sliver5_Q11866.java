import java.util.*;
import java.io.*;

public class Sliver5_Q11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> que = new LinkedList<>();


        for (int i = 1; i <= N; i++){
            que.offer(i);
        }

        sb.append("<");
        while (!que.isEmpty()){

            for (int j = 1; j < K; j++){
                int val = que.poll();
                que.offer(val);
            }

            if (que.size() == 1){
                sb.append(que.poll());
            } else {
                sb.append(que.poll()).append(", ");
            }

        }

        sb.append(">");

        System.out.println(sb);
    }
}
