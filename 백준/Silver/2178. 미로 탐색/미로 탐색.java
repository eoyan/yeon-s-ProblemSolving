import java.util.*;
import java.io.*;

public class Main {
    static class Point {
        int x, y;
        int node;
        Point(int x, int y, int n) {
            this.x = x;
            this.y = y;
            node = n;
        }
    }
    
    static int N;
    static int M;
    static int graph[][];
    static boolean visited[][];
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // Start of logic....

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        graph = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String row = br.readLine();

            for(int j = 0; j < M; j++) {
                graph[i][j] = row.charAt(j) - '0';
            }
        }

        bw.write(BFS(0, 0) + "\n");


        // print to result...
        bw.flush();                  
        br.close();
        bw.close();
    }

    public static int BFS(int x, int y) {
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(x, y, 1));
        visited[x][y] = true;

        while(!que.isEmpty()) {
            Point now = que.poll();

            if(now.x == N - 1 && now.y == M - 1) {
                return now.node;
            } 
            
            for(int i = 0; i < 4; i++) {
                int newX = now.x + dx[i];
                int newY = now.y + dy[i];

                if (newX < 0 || newX >= N || newY < 0 || newY >= M) {
                    continue;
                } 
                if (visited[newX][newY] == true || graph[newX][newY] == 0) {
                    continue;
                }

                que.add(new Point(newX, newY, now.node + 1));
                visited[newX][newY] = true;

            }
        }
        return 0;
    }

    
}