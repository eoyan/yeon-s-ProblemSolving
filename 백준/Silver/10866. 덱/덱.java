import java.io.*;


public class Main {

    static int M = 1000005;
    static int[] deque = new int[2*M + 1];
    static int head = M;
    static int tail = M; 

    static void push_front(int x) {
        deque[--head] = x;
    }

    static void push_back(int x) {
        deque[tail++] = x;
    }

    static int pop_front() {
        if (head == tail) {
            return -1;
        } 
        else {
            return deque[head++];
        }
    }

    static int pop_back() {
        if (head == tail) {
            return -1;
        }
        else {
            return deque[--tail];
        }
    }

    static int size() {
        return tail - head;
    }

    static int empty() {
        return head == tail ? 1: 0;
    }

    static int front() {
        return head == tail ? -1 : deque[head];
    }

    static int back() {
        return head == tail ? -1 : deque[tail - 1];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            String command = input[0];

            if (command.equals( "push_front")) {
                int x = Integer.parseInt(input[1]);
                push_front(x);
            }

            else if (command.equals( "push_back")) {
                int x = Integer.parseInt(input[1]);
                push_back(x);
            }

            else if (command.equals( "pop_front")) {
                bw.write(pop_front() + "\n");
            }

            else if (command.equals( "pop_back")) {
                bw.write(pop_back() + "\n");
            }

            else if (command.equals( "size")) {
                bw.write(size() + "\n");
            }
            
            else if (command.equals( "empty")) {
                bw.write(empty() + "\n");
            }

            else if (command.equals( "front")) {
                bw.write(front() + "\n");
            }

            else {
                bw.write(back() + "\n");
            }
            

        }
        bw.flush();
        bw.close();
        br.close();
        
    }
}