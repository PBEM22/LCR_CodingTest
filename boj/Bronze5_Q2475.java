package boj;

import java.util.*;
import java.io.*;

// 검증수
public class Bronze5_Q2475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int fir = Integer.parseInt(st.nextToken());
        int sec = Integer.parseInt(st.nextToken());
        int thi = Integer.parseInt(st.nextToken());
        int four = Integer.parseInt(st.nextToken());
        int five = Integer.parseInt(st.nextToken());

        fir *= fir;
        sec *= sec;
        thi *= thi;
        four *= four;
        five *= five;

        int result = (fir + sec + thi + four + five) % 10;

        System.out.println(result);
    }
}
