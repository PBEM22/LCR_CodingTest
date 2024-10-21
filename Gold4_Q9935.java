import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 상근이는 문자열에 폭발 문자열을 심어 놓았다. 폭발 문자열이 폭발하면 그 문자는 문자열에서 사라지며, 남은 문자열은 합쳐지게 된다.
 *
 * 폭발은 다음과 같은 과정으로 진행된다.
 *
 * 문자열이 폭발 문자열을 포함하고 있는 경우에, 모든 폭발 문자열이 폭발하게 된다. 남은 문자열을 순서대로 이어 붙여 새로운 문자열을 만든다.
 * 새로 생긴 문자열에 폭발 문자열이 포함되어 있을 수도 있다.
 * 폭발은 폭발 문자열이 문자열에 없을 때까지 계속된다.
 * 상근이는 모든 폭발이 끝난 후에 어떤 문자열이 남는지 구해보려고 한다. 남아있는 문자가 없는 경우가 있다. 이때는 "FRULA"를 출력한다.
 *
 * 폭발 문자열은 같은 문자를 두 개 이상 포함하지 않는다.
 *
 * [ 입력 ]
 * 첫째 줄에 문자열이 주어진다. 문자열의 길이는 1보다 크거나 같고, 1,000,000보다 작거나 같다.
 *
 * 둘째 줄에 폭발 문자열이 주어진다. 길이는 1보다 크거나 같고, 36보다 작거나 같다.
 *
 * 두 문자열은 모두 알파벳 소문자와 대문자, 숫자 0, 1, ..., 9로만 이루어져 있다.
 *
 * [ 출력 ]
 * 첫째 줄에 모든 폭발이 끝난 후 남은 문자열을 출력한다.
 */

public class Gold4_Q9935 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 결과 문자열을 담을 스택
        Stack<Character> strStack = new Stack<>();

        // 제공 받은 문자열
        String str = br.readLine();
        
        // 폭발 문자열
        String boom = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            strStack.push(str.charAt(i));

            // 폭발 문자열보다 크거나 같을때부터 체킹
            if (strStack.size() >= boom.length()){

                // 이어갈지 확인하는 변수
                boolean flag = true;

                // 반복해서 폭발문자열 찾기
                for (int j = 0; j < boom.length(); j++){

                    // 일치하지 않으면 바로 break 및 flag = false
                    if (strStack.get(strStack.size() - boom.length() + j) != boom.charAt(j)){
                        flag = false;
                        break;
                    }
                }

                // 폭발 문자열 존재시
                if (flag){

                    // 폭발 문자열의 길이만큼 pop
                    for (int j = 0; j < boom.length(); j++){
                        strStack.pop();
                    }
                }
            }
        }

        // 문자열이 비었을 시에 반환값
        if (strStack.isEmpty()){
            System.out.println("FRULA");
        }
        else {
            // 남은 문자열 출력 

            /**
             * 1번 (시간초과)
             */
//            for (int i = 0; i < strStack.size(); i++){
//                System.out.print(strStack.get(i));
//            }
            /**
             * 2번
             */
                // 남은 문자열 출력
                StringBuilder sb = new StringBuilder();
                for(Character c : strStack) {
                    sb.append(c);
                }
                System.out.println(sb);
        }

    }
}
