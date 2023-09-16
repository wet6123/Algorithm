import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        boolean[][] map = new boolean[N][M];
        boolean[][] visited = new boolean[N][M];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j = 0; j < M; j++) {
                if(line.charAt(j) - '0' == 1) {
                    map[i][j] = true;
                }
                visited[i][j] = false;
            }
        }
        
        Queue<Integer[]> queue = new LinkedList<>();
        Integer[] node = new Integer[2];
        node[0] = 0;
        node[1] = 0;
        queue.add(node);
        
        int ans = 0;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for(int s = 0; s < size; s++) {
                node = queue.poll();
                
                if(node[0] == N-1 && node[1] == M-1) {
                    ans++;
                    bw.write(ans + "");
                    bw.close();
                    return;
                }
                
                for(int i = 0; i < 4; i++) {
                    int nx = node[0] + dx[i];
                    int ny = node[1] + dy[i];
                    
                    if(nx < 0 || ny < 0 || nx >= N || ny >= M)
                        continue;
                    
                    if(!visited[nx][ny] && map[nx][ny]) {
                        visited[nx][ny] = true;
                        Integer[]  next = new Integer[2];
                        next[0] = nx;
                        next[1] = ny;
                        queue.add(next);
                    }
                }
            }
            ans++;
        }
    }
}