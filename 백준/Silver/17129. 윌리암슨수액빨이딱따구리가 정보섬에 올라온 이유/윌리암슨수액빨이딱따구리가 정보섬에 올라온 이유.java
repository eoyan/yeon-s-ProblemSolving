import java.util.*;
import java.io.*;

public class Main {

    static class Location {
        int x, y;
        int n;
        Location(int x, int y, int n) {
            this.x = x;
            this.y = y;
            this.n = n;
        }
    }

    static int n, m;
    static int graph[][];
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        graph = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            String row = br.readLine();
            for(int j = 0; j < m; j++) {
                graph[i][j] = row.charAt(j) - '0';
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(graph[i][j] == 2) {
                    int distance = BFS(i, j);
                    if(distance == -1) {
                        bw.write("NIE" + "\n");
                    }
                    else {
                        bw.write("TAK" + "\n");
                        bw.write(distance + "\n");
                    }
                    bw.flush();
                }
            }
        }
        bw.close();
        br.close();
    }

    public static int BFS(int x, int y) {
        Queue<Location> que = new LinkedList<>();
        que.add(new Location(x, y, 1));
        visited[x][y] = true;

        while(!que.isEmpty()) {
            Location now = que.poll();
            if(graph[now.x][now.y] > 2) return now.n - 1;
            now.n++;
            for(int i = 0; i < 4; i++) {
                
                int newX = now.x + dx[i];
                int newY = now.y + dy[i];

                if(newX < 0 || newY < 0 || newX >= n || newY >= m) {
                    continue;
                }

                if(visited[newX][newY] || graph[newX][newY] == 1) {
                    continue;
                }

                que.add(new Location(newX, newY, now.n));
                visited[newX][newY] = true;
            }
        }
        return -1;
    }
}