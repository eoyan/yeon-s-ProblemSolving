import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int x;
        int time;

        Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }

    static boolean visited[] = new boolean[100001];
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input[] = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

         // 시작점은 무조건 수빈이가 있는 곳

        int res = BFS(N, K);
        bw.write(res + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int BFS(int x, int target) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(x, 0));
        visited[x] = true;
        
        while (!que.isEmpty()) {
            Node node = que.poll();
            
            if (node.x == target) return node.time;
            int[] nextList = getNext(node.x);
            
            for(int n : nextList) {

                if (n < 0 || n > 100000) continue;
                if (visited[n] == true) continue;

                que.add(new Node(n, node.time + 1 ));
                visited[n] = true;
            }
        }
        return -1;
    }
    public static int[] getNext(int x) {
        return new int[] { x + 1, x - 1, x * 2 };
    }
}





