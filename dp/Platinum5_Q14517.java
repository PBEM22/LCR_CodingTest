package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 팰린드롬 개수 구하기 (Large)
 *
 * 팰린드롬(palindrome)이란 앞에서부터 읽으나 뒤에서부터 읽으나 같은 단어를 말한다.
 *  'aba'나 'a'와 같은 단어는 팰린드롬이며, 'abaccbcb'나 'anavolimilana'와 같은 단어는 팰린드롬이 아니다.
 *
 *  예를들어 'abb' 의 부분수열은 {'a'}, {'b'}, {'b'}, {'ab'}, {'ab'}, {'bb'}, {'abb'} 이고
 *  이 가운데 팰린드롬은 {'a'}, {'b'}, {'b'}, {'bb'} 으로 4개 이다.
 *
 * input
 * 첫째 줄에 길이가 1000을 넘지 않는 문자열 S 가 주어진다. 문자열 S는 알파벳 소문자로만 이루어져 있다.
 *
 * output
 * 주어진 문자열 S 의 부분수열 중 팰린드롬이 되는 부분수열의 개수를 10,007 로 나눈 나머지를 출력한다.
 */
public class Platinum5_Q14517 {

    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = line.length();
        int mod = 10007;
        dp = new int[line.length()][line.length()];

        // 부분수열의 길이가 1일때는 무조건 모두 1개씩
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // 부분수열의 길이가 2일때는 같으면 3, 다르면 2
        for (int i = 1; i < n; i++) {
            dp[i - 1][i] = 2;
            if (line.charAt(i - 1) == line.charAt(i)) {
                dp[i-1][i]++;
            }
        }

        // 3개 이상시에 같으면 부분수열의 합, 다르면 가운데 부분 한 번 빼주기 (합집합간의 관계성)
        for (int i = 2; i < n; i++){
            for (int j = i; j < n; j++){
                 if (line.charAt(j) == line.charAt(j - i)) {
                     dp[j-i][j] = (dp[j-i][j-1] + dp[j-i+1][j] + 1) % mod;
                 } else {
                     dp[j-i][j] = (dp[j-i][j-1] + dp[j-i+1][j] - dp[j-i+1][j-1] + mod) % mod;
                 }
            }
        }
        // mod를 더하는 이유는 음수 방지를 위해서이다.
        // Math.abs를 사용해서 음수를 양수로 바꿔주는것은 통과되지 않았다.
        // line의 [i] 부터 [j]까지의 합을 더해주고 수가 같으면 +1, 틀리다면 사이의 값을 없애줬다.
        System.out.println(dp[0][n-1]);
    }
}
