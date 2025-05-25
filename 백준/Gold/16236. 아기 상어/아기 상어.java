import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {-1, 0, 0, 1};
    static Queue<Coor> q = new LinkedList<>();
    static int eat_cnt, shark_size, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int now = Integer.parseInt(st.nextToken());
                if (now == 9) {
                    map[i][j] = 0;
                    q.offer(new Coor(j, i));
                    visited[i][j] = true;
                } else {
                    map[i][j] = now;
                }
            }
        }

        eat_cnt = 0;
        shark_size = 2;
        ans = 0;
        while(!q.isEmpty()) {
            bfs();
        }
        
        bw.write(ans + "");
        bw.close();
    }

    static class Coor {
        int x, y;
        
        Coor(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void bfs() {
        int cnt = 0;
        while(!q.isEmpty()) {
            cnt++;
            int size = q.size();
            for(int q_cnt = 0; q_cnt < size; q_cnt++) {
                Coor now = q.poll();
                for(int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                        continue;
                    if (visited[ny][nx] || map[ny][nx] > shark_size)
                        continue;
                    boolean cannot = false;
                    if (i == 3) {
                        for(int j = 1; j < 4; j++) {
                            int nnx = nx + dx[j];
                            int nny = ny + dy[j];
                            if (nnx < 0 || nnx >= N || nny < 0 || nny >= N)
                                continue;
                            if (visited[nny][nnx]) {
                                cannot = true;
                                break;
                            }
                        }
                    }
                    if (cannot == false) {
                        if (map[ny][nx] == 0 || map[ny][nx] == shark_size) {
                            q.offer(new Coor(nx, ny));
                            visited[ny][nx] = true;
                        } else {
                            q.clear();
                            map[ny][nx] = 0;
                            ans += cnt;
                            eat_cnt++;
                            if (eat_cnt == shark_size) {
                                shark_size++;
                                eat_cnt = 0;
                            }
                            q.offer(new Coor(nx, ny));
                            visited = new boolean[N][N];
                            visited[ny][nx] = true;
                            return;
                        }
                    }
                }
            }
        }
    }
}
