import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 게임
 *
 * 게임 기록은 다음과 같이 생겼다.
 *
 * 게임 횟수 : X
 * 이긴 게임 : Y (Z%)
 * Z는 형택이의 승률이고, 소수점은 버린다. 예를 들어, X=53, Y=47이라면, Z=88이다.
 * X와 Y가 주어졌을 때, 형택이가 게임을 최소 몇 번 더 해야 Z가 변하는지 구하는 프로그램을 작성하시오.
 *
 * 각 줄에 정수 X와 Y가 주어진다.
 *
 * 첫째 줄에 형택이가 게임을 최소 몇 판 더 해야하는지 출력한다. 만약 Z가 절대 변하지 않는다면 -1을 출력한다.
 */

public class Silver3_Q1072 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());

        int Z = (int)(100 * Y / X);

        int count = 0;

        if (Z >= 99) System.out.println(-1);
        else {
            int left = 0;
            int right = 1000000000;

            while (left <= right){
                int mid = (left + right) / 2;
                int result = (int)((100 * (Y+mid)) / (X + mid));
                if (result <= Z){
                    left = mid + 1;
                    count = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            System.out.println(count);
        }


    }
}
