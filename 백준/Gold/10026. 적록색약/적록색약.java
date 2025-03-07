import java.util.*;
import java.io.*;

public class Main {

    static class Location {
        int x, y;
        Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static char graph[][];
    static boolean visited[][];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, 1, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        graph = new char[N][N];
        visited = new boolean[N][N];


        for(int i = 0 ; i < N; i++) {
            String row = br.readLine();
            for(int j = 0; j < N; j++) {
                graph[i][j] = row.charAt(j);
            }
        }

        int nomalCount = 0;
        int colorBlindCount = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    BFS(i, j, graph[i][j]);
                    nomalCount++;
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j =0; j < N; j++) {
                if(graph[i][j] == 'G') graph[i][j] = 'R';
            }
        }

        for(boolean[] i : visited) {
            Arrays.fill(i, false);
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    BFS(i, j, graph[i][j]);
                    colorBlindCount++; 
                }
            }
        }

        bw.write(nomalCount + " " + colorBlindCount + "\n");
        bw.flush();
        bw.close();
        br.close();

    }
    public static int BFS(int x, int y, char color) {
        Queue<Location> que = new LinkedList<>();
        que.add(new Location(x, y));
        visited[x][y] = true;

        while(!que.isEmpty()) {
            Location now = que.poll();
            for(int i =0; i < 4;i ++) {
                int newX = now.x + dx[i];
                int newY = now.y + dy[i];

                if(newX < 0 || newY < 0 || newX >= N || newY >= N) {
                    continue;
                }
                if(visited[newX][newY] || graph[newX][newY] != color) {
                    continue;
                }

                que.add(new Location(newX, newY));
                visited[newX][newY] = true;
            }
        }
        
        return 0;
    }
    
}