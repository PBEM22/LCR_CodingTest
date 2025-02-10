package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

// 그룹 단어 체커
public class Silver5_Q1316 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;
        int N = Integer.parseInt(br.readLine());

        String[] word = new String[N];

        boolean[] asc = new boolean[27];

        for (int i = 0; i < N; i++){
            word[i] = br.readLine();
        }

        for (int i = 0; i < N; i++){
            Stack<Character> stack = new Stack<>();
            int count = 0;
            stack.push(word[i].charAt(0));
            asc[word[i].charAt(0) - 'a'] = true;

            for (int j = 1; j < word[i].length(); j++){

                char pop = stack.pop();

                if (pop != word[i].charAt(j) && !asc[word[i].charAt(j)-'a']){
                    asc[word[i].charAt(j)-'a'] = true;
                    stack.push(word[i].charAt(j));

                } else if (pop != word[i].charAt(j) && asc[word[i].charAt(j)-'a']) {
                    count++;
                    break;
                } else {
                    stack.push(word[i].charAt(j));
                }
            }

            if (count == 0){
                result++;
            }

            Arrays.fill(asc, false);
        }

        System.out.println(result);
    }
}
