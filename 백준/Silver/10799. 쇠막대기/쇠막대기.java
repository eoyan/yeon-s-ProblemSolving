import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Start of logic....

        Stack<Character> stack = new Stack<>();
        String input = br.readLine();
        int total = 0;
        boolean isEndOfStick = false;
        // 여는 괄호면 무조건 push
        for(char c : input.toCharArray()) {
            
            if(c == '(') {
                stack.push('(');
                isEndOfStick = false;
            }

            else if (c == ')') {
                stack.pop(); // 닫힌 괄호를 만나는 경우는 레이저일 경우와 막대기가 끝난 경우로 나뉠 수 있음
                
                // 레이저가 끝나고 막대기의 끝 [ ) ) ] 일 경우
                if (isEndOfStick) {
                    total += 1;
                }

                else if (!stack.isEmpty()){
                    total += stack.size();
                }
                isEndOfStick = true;
            }
        }
        bw.write(total + "\n");
    
        // print to result...
        bw.flush();                  
        br.close();
        bw.close();
    }
}