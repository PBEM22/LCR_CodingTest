package boj;

import java.io.*;
import java.util.StringTokenizer;


// 10대의 컴퓨터 => 일의 자리가 0이면, 10번째 컴퓨터가 처리
public class bronze_1009 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(bf.readLine());

        for (int i = 0; i < T; i++){
            st = new StringTokenizer(bf.readLine());

            // 데이터의 갯수 => a의 b제곱
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int sum = sum(a, b);

            System.out.println(sum);

        }

        bf.close();
    }

    public static int sum(int a, int b){
        int data = 1;

        if (b == 0){
            return 1;
        } else if (b == 1) {
            return a;
        } else {
            for (int j = 1; j <= b; j++) {
                data = data * a % 10;  // a * a로 시작 만약, b가 0이면 1, b가 1이면 a
            }

            return data == 0 ? 10 : data;
        }


    }
}
