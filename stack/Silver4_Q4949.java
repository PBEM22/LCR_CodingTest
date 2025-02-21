package stack;

import java.io.*;
import java.util.*;

// 균형잡힌 세상
public class Silver4_Q4949 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){

            String str = br.readLine();

            Stack<Character> stack = new Stack<>();

            if (str.equals(".")){

                break;
            }

            for (int i = 0; i < str.length(); i++){

                if (str.charAt(i) == '(' || str.charAt(i) == '['){
                    stack.push(str.charAt(i));
                } else if (str.charAt(i) == ')'){

                    if (stack.isEmpty() || stack.peek() != '('){
                        sb.append("no\n");
                        break;
                    } else {
                        stack.pop();
                    }

                } else if (str.charAt(i) == ']') {

                    if (stack.isEmpty() || stack.peek() != '['){
                        sb.append("no\n");
                        break;
                    } else {
                        stack.pop();
                    }
                } else if (str.charAt(i) == '.') {

                    if (stack.isEmpty()){
                        sb.append("yes\n");
                    } else {
                        sb.append("no\n");
                    }
                }
            }

        }

        System.out.println(sb);
    }

}
