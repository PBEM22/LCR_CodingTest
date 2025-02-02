package boj;

import java.util.*;
import java.io.*;

public class Bronze1_Q1032 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[] pattern = br.readLine().toCharArray();

        for (int i = 0; i < N-1; i++){

            char[] test = br.readLine().toCharArray();

            for (int j = 0; j < test.length; j++){

                if (pattern[j] != test[j]) {
                    pattern[j] = '?';
                }
            }

        }

        System.out.println(Arrays.toString(pattern));
    }
}

/**
 * 첫째 줄에 파일 이름의 개수 N이 주어진다. 둘째 줄부터 N개의 줄에는 파일 이름이 주어진다.
 * N은 50보다 작거나 같은 자연수이고 파일 이름의 길이는 모두 같고 길이는 최대 50이다.
 * 파일이름은 알파벳 소문자와 '.' 로만 이루어져 있다.
 *
 *
 * EX)
 * 3
 * config.sys
 * config.inf
 * configures
 *
 * A)
 * config????
 *
 *
 * EX2)
 * 2
 * contest.txt
 * context.txt
 *
 * A)
 * conte?t.txt
 *
 */
