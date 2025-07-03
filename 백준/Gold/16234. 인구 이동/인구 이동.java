import java.io.*;
import java.util.*;

public class Main {
    static int N, L, R;
    static int[][] A;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int days = 0;
        
        while (true) {
            visited = new boolean[N][N];
            boolean hasMovement = false;
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        List<int[]> union = bfs(i, j);
                        
                        if (union.size() > 1) {
                            hasMovement = true;
                            
                            int totalPeople = 0;
                            for (int[] pos : union) {
                                totalPeople += A[pos[0]][pos[1]];
                            }
                            
                            int newPeople = totalPeople / union.size();
                            
                            for (int[] pos : union) {
                                A[pos[0]][pos[1]] = newPeople;
                            }
                        }
                    }
                }
            }
            
            if (!hasMovement) {
                break;
            }
            
            days++;
        }
                
        bw.write(String.valueOf(days + "\n"));
        bw.close();
    }
    
    static List<int[]> bfs(int startR, int startC) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> union = new ArrayList<>();
        
        queue.offer(new int[]{startR, startC});
        union.add(new int[]{startR, startC});
        visited[startR][startC] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];
                
                if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
                    int diff = Math.abs(A[r][c] - A[nr][nc]);
                    if (diff >= L && diff <= R) {
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                        union.add(new int[]{nr, nc});
                    }
                }
            }
        }
        
        return union;
    }
}