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

    static int N, M;
    static int graph[][];
    static boolean visited[][];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        graph = new int[N][M];
        visited = new boolean[N][M];
        int maxSize = 0;
        int allPicturesCount = 0;
        
        for(int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for(int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(row[j]);
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!visited[i][j] && graph[i][j] == 1) {
                    int pictureSize = BFS(i, j);
                    maxSize = pictureSize > maxSize ? pictureSize : maxSize; 
                    allPicturesCount++;
                    
                }
            }
        }

        bw.write(allPicturesCount + "\n");
        bw.write(maxSize + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int BFS(int x, int y) {
        Queue<Location> que = new LinkedList<>();
        que.add(new Location(x, y));
        visited[x][y] = true;
        int count = 1;

        while(!que.isEmpty()) {
            Location now = que.poll();
            
            for(int i = 0; i < 4; i++) {
                int newX = now.x + dx[i];
                int newY = now.y + dy[i];

                if(newX < 0 || newY < 0 || newX >= N || newY >= M) continue;
                if(visited[newX][newY] || graph[newX][newY] == 0) continue;

                que.add(new Location(newX, newY));
                visited[newX][newY] = true;
                count++;
            } 
        }
        return count;

    }
    
}