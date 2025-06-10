import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    static int N, M;
    static boolean[][] map;
    static boolean[][] air;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];
        int cnt = 0;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) == 1;
                if (map[i][j]) cnt++;
            }
        }

        int ans = 0;

        while(cnt > 0) {
            findAir();
            
            List<int[]> toMelt = new ArrayList<>();
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(map[i][j]) {
                        int airContact = 0;
                        for(int k = 0; k < 4; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if(nx >= 0 && nx < N && ny >= 0 && ny < M && air[nx][ny]) {
                                airContact++;
                            }
                        }
                        if(airContact >= 2) {
                            toMelt.add(new int[]{i, j});
                        }
                    }
                }
            }
            
            for(int[] pos : toMelt) {
                map[pos[0]][pos[1]] = false;
                cnt--;
            }
            
            ans++;
        }
        
        bw.write(ans + "");
        bw.close();
    }
    
    static void findAir() {
        air = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{0, 0});
        air[0][0] = true;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >= 0 && nx < N && ny >= 0 && ny < M && 
                   !air[nx][ny] && !map[nx][ny]) {
                    air[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }
}