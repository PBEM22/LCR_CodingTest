package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2007년
public class Bronze1_Q1924 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        String[] day = new String[7];
        int[] month = new int[13];

        day[0] = "MON";
        day[1] = "TUE";
        day[2] = "WED";
        day[3] = "THU";
        day[4] = "FRI";
        day[5] = "SAT";
        day[6] = "SUN";

        month[1] = 31;
        month[2] = 28;
        month[3] = 31;
        month[4] = 30;
        month[5] = 31;
        month[6] = 30;
        month[7] = 31;
        month[8] = 31;
        month[9] = 30;
        month[10] = 31;
        month[11] = 30;
        month[12] = 31;

        int temp = 0;

        for (int i = 1; i < X; i++) {
            temp += month[i];
        }

        temp += Y;
        temp = temp % 7;

        if (temp == 0){
            System.out.println(day[6]);
        } else {
            System.out.println(day[temp-1]);
        }
    }
}
