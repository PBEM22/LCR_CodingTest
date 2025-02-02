package boj;

import java.io.*;

public class Silver4_Q2839 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if(N < 3 || N == 4 || N == 7) System.out.println(-1);
        // 5의 배수
        else if (N % 5 == 0) {
            System.out.println(N / 5);
        } else if (N % 5 == 1 || N % 5 == 3) { // 5로 나눴을 때, 나머지 1 또는 3
            System.out.println(N / 5 + 1);
        } else if (N % 5 == 2 || N % 5 == 4) {  // 5로 나눠씅ㄹ 때, 나머지 2 또는 4
            System.out.println(N / 5 + 2);
        } else{
            System.out.println(-1);
        }

    }
}


/**
 * 점화식 => 5, 3
 *      1   2   3   4   5   6   7   8   9   10   11   12   13   14   15   16   17   18   19   20   21  22
 *     -1  -1      -1          -1                                                                    -1
 * 3            1           2       1   3        2    4         3         2    4    1    3    0    2
 * 5                   1            1       2    1              1    3    2    1    3    2    4    3
 * 봉지 -1 -1   1   -1  1   2   -1   2   3   2    3    4     3   4    3    4    5    4    5    4    5   -1
 * n/5  0  0   0    0  1   1    1   1   1   2    2    2     2   2    3    3    3    3    3    4    4    4
 * n%5  1  1   3    4  0   1    2   3   4   0    1    2     1   4    0    1    2    3    4    0    1    2
 */


/**
 * 상근이는 귀찮기 때문에, 최대한 적은 봉지를 들고 가려고 한다. 예를 들어, 18킬로그램 설탕을 배달해야 할 때, 3킬로그램 봉지 6개를 가져가도 되지만, 5킬로그램 3개와 3킬로그램 1개를 배달하면, 더 적은 개수의 봉지를 배달할 수 있다.
 *
 * 상근이가 설탕을 정확하게 N킬로그램 배달해야 할 때, 봉지 몇 개를 가져가면 되는지 그 수를 구하는 프로그램을 작성하시오.
 * 상근이가 배달하는 봉지의 최소 개수를 출력한다. 만약, 정확하게 N킬로그램을 만들 수 없다면 -1을 출력한다.
 */