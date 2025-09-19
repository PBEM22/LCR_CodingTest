package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Silver2_Q1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int min = 0;
        // '-'가 중요 - 이후로는 다 괄호로 묶기.
        String[] split = s.split("-");

        // 첫 번째 요소는 무조건 +
        min += calculateSum(split[0]);

        // 다 더하기
        for (int i = 1; i < split.length; i++){
            min -= calculateSum(split[i]);
        }

        System.out.println(min);
    }

    // 문자열에 포함된 숫자 합 계산
    private static int calculateSum(String input){
        String[] numbers = input.split("\\+");
        int sum = 0;
        for (int i = 0; i < numbers.length; i++){
            sum += Integer.parseInt(numbers[i]);
        }
        return sum;
    }
}
