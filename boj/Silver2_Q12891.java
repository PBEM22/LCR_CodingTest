package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// DNA 비밀번호
public class Silver2_Q12891 {

    // 필요한 A, C, G, T의 수
    static int[] DNA = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        char[] charArray = br.readLine().toCharArray();
        int[] resultDNA = new int[4];
        int result = 0;

        st = new StringTokenizer(br.readLine());
        
        DNA[0] = Integer.parseInt(st.nextToken());
        DNA[1] = Integer.parseInt(st.nextToken());
        DNA[2] = Integer.parseInt(st.nextToken());
        DNA[3] = Integer.parseInt(st.nextToken());

        // 첫 문자열
        for (int i = 0; i < P; i++) {
            switch (charArray[i]){
                case 'A': resultDNA[0]++; break;
                case 'C': resultDNA[1]++; break;
                case 'G': resultDNA[2]++; break;
                case 'T': resultDNA[3]++; break;
                default: break;
            }
        }

        if (check(resultDNA)){
            result++;
        }

        for (int i = P; i < S; i++) {

            int startIndex = i - P;

            switch (charArray[startIndex]){
                case 'A': resultDNA[0]--; break;
                case 'C': resultDNA[1]--; break;
                case 'G': resultDNA[2]--; break;
                case 'T': resultDNA[3]--; break;
                default: break;
            }

            switch (charArray[i]){
                case 'A': resultDNA[0]++; break;
                case 'C': resultDNA[1]++; break;
                case 'G': resultDNA[2]++; break;
                case 'T': resultDNA[3]++; break;
                default: break;
            }

            if (check(resultDNA)){
                result++;
            }
        }

        System.out.println(result);
    }

    static boolean check(int[] resultDNA){

        for (int i = 0; i < resultDNA.length; i++){

            if (resultDNA[i] < DNA[i]){
                return false;
            }
        }

        return true;
    }
}
