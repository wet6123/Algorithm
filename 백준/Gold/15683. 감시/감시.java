import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] office;
    static ArrayList<int[]> cctvs;
    static int minBlindSpot = Integer.MAX_VALUE;
    
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    static int[][][] cctvDirections = {
        {},
        {{0}, {1}, {2}, {3}},
        {{0, 2}, {1, 3}},
        {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
        {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}},
        {{0, 1, 2, 3}}
    };
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        office = new int[N][M];
        cctvs = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                if (office[i][j] >= 1 && office[i][j] <= 5) {
                    cctvs.add(new int[]{i, j, office[i][j]});
                }
            }
        }
        
        backtrack(0, office);
        
        bw.write(String.valueOf(minBlindSpot));
        bw.flush();
        bw.close();
        br.close();
    }
    
    static void backtrack(int depth, int[][] currentOffice) {
        if (depth == cctvs.size()) {
            int blindSpot = countBlindSpot(currentOffice);
            minBlindSpot = Math.min(minBlindSpot, blindSpot);
            return;
        }
        
        int[] cctv = cctvs.get(depth);
        int x = cctv[0];
        int y = cctv[1];
        int type = cctv[2];
        
        for (int[] directions : cctvDirections[type]) {
            int[][] newOffice = copyOffice(currentOffice);
            
            for (int dir : directions) {
                surveillance(newOffice, x, y, dir);
            }
            
            backtrack(depth + 1, newOffice);
        }
    }
    
    static void surveillance(int[][] office, int x, int y, int dir) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        
        while (nx >= 0 && nx < N && ny >= 0 && ny < M) {
            if (office[nx][ny] == 6) {
                break;
            }
            if (office[nx][ny] == 0) {
                office[nx][ny] = -1;
            }
            nx += dx[dir];
            ny += dy[dir];
        }
    }
    
    static int countBlindSpot(int[][] office) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (office[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
    
    static int[][] copyOffice(int[][] office) {
        int[][] newOffice = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newOffice[i][j] = office[i][j];
            }
        }
        return newOffice;
    }
}