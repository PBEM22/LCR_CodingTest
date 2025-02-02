package dp;

// 1, 2, 3 더하기

import java.io.*;

public class Silver3_Q9095 {

    static Integer[] DP = new Integer[11];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트 케이스 갯수
        Integer T = Integer.parseInt(br.readLine());

        DP[1] = 1;
        DP[2] = 2;
        DP[3] = 4;

        // DP[n] = DP[n-1] + DP[n-2] + DP[n-3]

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            // 3보다 작을 때에만 저장
            if (n <= 3){
                bw.write(DP[n] + "\n");
            } else {
                topDown(n);
                bw.write(DP[n] + "\n");
            }
        }

        bw.flush();
    }

    static Integer topDown(int n){

        if (n <= 3){
            return DP[n];
        } else {
            DP[n] = topDown(n-1) + topDown(n-2) + topDown(n-3);
            return DP[n];
        }
    }
}
