package codingtest;
import java.util.*;
import java.io.*;

public class Silver_1789{
    public static void main(String[] args) throws IOException {
        // 서로 다른 N개의 자연수의 합 == S
        // S는 주어짐
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());
        long sum = 0;
        int count = 0;
        
        for(int i = 1; sum <= S; i++){
            sum += i;
            count++;
        }
        br.close();
        System.out.println(count - 1);
    }
}