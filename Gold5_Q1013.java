/**
 *
 * 전파의 기본 단위는 { 0 , 1 } 두 가지로 구성되어있으며, x+ ( ) 는 임의의 개수(최소 1개) x의 반복으로 이루어진 전파의 집합을 나타낸다.
 *
 * (xyx)+ ( ) 는 괄호 내의 xyx의 반복으로 이루어진 전파의 집합을 뜻한다. 아래는 이해를 돕기 위한 예제이다.
 *
 * 1+ = { 1, 11, 111, 1111, 11111, … }
 * 10+ = { 10, 100, 1000, 10000, 100000, … }
 * (01)+ = { 01, 0101, 010101, 01010101, 0101010101, … }
 *
 * Q.
 * (100+1+ | 01)+ 패턴을 판단하는 프로그램
 */

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Gold5_Q1013 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int i = 0;

        String pattern = "(100+1+|01)+";

        String temp = "";


        while (i < T) {

            temp = br.readLine();

            if (Pattern.matches(pattern, temp)) {
                bw.write("YES\n");
            } else {

                bw.write("NO\n");
            }

            i++;
        }

        bw.flush();
        bw.close();
    }
}
