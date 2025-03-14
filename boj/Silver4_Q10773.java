package boj; /**
 * // 입력
 * 첫 번째 줄에 정수 K가 주어진다. (1 ≤ K ≤ 100,000)
 *
 * 이후 K개의 줄에 정수가 1개씩 주어진다. 정수는 0에서 1,000,000 사이의 값을 가지며,
 *
 * 정수가 "0" 일 경우에는 가장 최근에 쓴 수를 지우고, 아닐 경우 해당 수를 쓴다.
 *
 * 정수가 "0"일 경우에 지울 수 있는 수가 있음을 보장할 수 있다.
 *
 * // 출력
 * 재민이가 최종적으로 적어 낸 수의 합을 출력한다. 최종적으로 적어낸 수의 합은 231-1보다 작거나 같은 정수이다.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Silver4_Q10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int index = Integer.parseInt(br.readLine());    // 정수 K
        int K = 0;
        List<Integer> arr = new ArrayList<>();

        for(int i = 0; i < index; i++){
            K = Integer.parseInt(br.readLine());

            if (K == 0 && !arr.isEmpty()){
                arr.remove(arr.size()-1);
            } else {
                arr.add(K);
            }
        }

        int[] result = new int[arr.size()];

        for (int i = 0; i < result.length; i++){
            result[i] = arr.get(i);
        }

        int sum = Arrays.stream(result).sum();

        System.out.println(sum);
    }
}
