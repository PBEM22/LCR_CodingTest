package boj;

import java.util.*;
import java.io.*;

// 단어 정렬
public class Silver5_Q1181 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> strMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            strMap.put(line, line.length());
        }

        List<String> keySet = new ArrayList<>(strMap.keySet());

        keySet.sort((o1, o2) -> {
            if (o1.length() == o2.length()){
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });

        for (String key : keySet) {
            sb.append(key).append("\n");
        }

        System.out.println(sb);
    }
}
