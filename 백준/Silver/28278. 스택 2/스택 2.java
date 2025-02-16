import java.io.*;

public class Main {

    private int[] stack = new int[1000000];
    private int top = -1;

    // 1
    public void push(int x) {
        stack[++top] = x;
    }

    // 2
    public int pop() {
        if (top == -1) return -1;
        else return (stack[top--]);
    } 

    // 3
    public int count() {
        return top + 1;
    }

    // 4
    public int isEmpty() {
        if(top >= 0) {
            return 0; // 안 비어있음
        }
        else return 1; // 비어있음
    }

    // 5
    public int peek() {
        if(isEmpty() == 0) {
            return stack[top];
        }
        else {
            return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        Main stk = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            String input = br.readLine().trim();
            String[] tokens = input.split(" ");

            int command = Integer.parseInt(tokens[0]);

            switch (command) {
                case 1 : 
                    int x = Integer.parseInt(tokens[1]);
                    stk.push(x);
                    break;

                case 2 :
                    bw.write(stk.pop() + "\n");
                    break;
                
                case 3 :
                    bw.write(stk.count() + "\n");
                    break;

                case 4 :
                    bw.write(stk.isEmpty() + "\n");
                    break;
                
                case 5 :
                    bw.write(stk.peek() + "\n");
                    break;

                default :
                    break;
            }
        }
        bw.flush();
    }
}