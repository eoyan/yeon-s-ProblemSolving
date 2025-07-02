import java.util.Stack;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   

        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();

        String str = br.readLine();

        for(char ch : str.toCharArray()) {
            if (ch == '(' || ch == '[') {
                stack.push(String.valueOf(ch));
            }

            else {
                int sum = 0;
                boolean matched = false;

                while (!stack.isEmpty()) {
                   
                    String top = stack.pop();
                    
                    if (top.equals("(") && ch == ')') {
                        stack.push(String.valueOf(sum == 0 ? 2 : sum * 2));
                        matched = true;
                        break;
                    }
                    else if (top.equals("[") && ch == ']') {
                        stack.push(String.valueOf(sum == 0 ? 3 : 3 * sum));
                        matched = true;
                        break;
                    }
                    else {
                        try {
                            sum += Integer.parseInt(top); // 숫자라면 누적!
                        } catch (NumberFormatException e) {
                            System.out.println(0); // 숫자도 괄호도 아니면 에러!
                            return;
                        }
                    }
                }

                if (!matched) {
                    System.out.println(0);
                    return;
                }
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            String s = stack.pop();
            try {
                result += Integer.parseInt(s);
            }
            catch (NumberFormatException e) {
                System.out.println(0); // 괄호가 남아있으면 에러
                return;
            }
        }

        System.out.println(result);
        br.close();

    }
}