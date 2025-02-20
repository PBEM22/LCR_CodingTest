package boj;

import java.util.*;
import java.io.*;

/**
 * 압축 좌표 원리
 * (0, 3), (1, 10), (2, 40), (3, 12)
 *
 * -> (인덱스, 값)을 값으로 오름차순 정렬
 * (0, 3), (1, 10), (3, 12), (2, 40)
 *
 * -> 좌표를 뒤에 숫자에 다시 정해주기
 * (0, 0), (1, 1), (3, 2), (2, 3)
 *
 * -> 기존 값들 사라지고 인덱스를 통한 순서만 남음, 다시 인덱스를 사용해 원래 순서로 변경
 * (0, 0), (1, 1), (2, 3), (3, 2)
 *
 * -> 값은 사라지고 순서만 남음
 * 0, 1, 3, 2
 */
// 좌표 압축
public class Silver2_Q18870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];
        long[] copyArr = new long[N];

        String[] s = br.readLine().split(" ");

        for (int i = 0; i < s.length; i++) {
            arr[i] = Long.parseLong(s[i]);
            copyArr[i] = Long.parseLong(s[i]);
        }

        Arrays.sort(copyArr);

        Map<Long, Long> map = new HashMap<>();

        long j = 0;
        for (long v : copyArr) {

            if (!map.containsKey(v)) {
                map.put(v, j);
                j++;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (long key : arr) {
            long rank = map.get(key);
            sb.append(rank).append(" ");
        }

        System.out.println(sb);
    }
}
