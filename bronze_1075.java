import java.io.*;
import java.util.*;

/**
 * 정수 N의 가장 뒤 두 자리를 적절히 바꿔서 N을 F로 나누어 떨어지게 만들려고 한다.
 * 첫째 줄에 N, 둘째 줄에 F가 주어진다. N은 100보다 크거나 같고, 2,000,000,000보다 작거나 같은 자연수이다.
 * F는 100보다 작거나 같은 자연수이다.
 */
public class bronze_1075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());
        N /= 100;
        N *= 100;

        int F = Integer.parseInt(br.readLine());
        int count = 0;

        while (N % F != 0){
            N++;
            count++;
        }
        if (count < 10){
            System.out.println("0" + count);
        } else {
            System.out.println(count);
        }
    }
}
