import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int maxBlock = 0;
    static boolean[][] merged;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        
        int[][] board = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                maxBlock = Math.max(maxBlock, board[i][j]);
            }
        }
        
        dfs(0, board);
        
        bw.write(maxBlock + "\n");
        bw.close();
    }
    
    static void dfs(int depth, int[][] board) {
        if (depth == 5) return;
        
        for (int dir = 0; dir < 4; dir++) {
            int[][] nextBoard = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    nextBoard[i][j] = board[i][j];
                }
            }
            
            if (move(nextBoard, dir)) {
                dfs(depth + 1, nextBoard);
            }
        }
    }
    
    static boolean move(int[][] board, int dir) {
        boolean moved = false;
        merged = new boolean[N][N];
        
        if (dir == 0) {
            for (int j = 0; j < N; j++) {
                for (int i = 1; i < N; i++) {
                    if (board[i][j] == 0) continue;
                    moved |= moveBlock(board, i, j, -1, 0);
                }
            }
        }
        else if (dir == 1) {
            for (int j = 0; j < N; j++) {
                for (int i = N-2; i >= 0; i--) {
                    if (board[i][j] == 0) continue;
                    moved |= moveBlock(board, i, j, 1, 0);
                }
            }
        }
        else if (dir == 2) {
            for (int i = 0; i < N; i++) {
                for (int j = 1; j < N; j++) {
                    if (board[i][j] == 0) continue;
                    moved |= moveBlock(board, i, j, 0, -1);
                }
            }
        }
        else {
            for (int i = 0; i < N; i++) {
                for (int j = N-2; j >= 0; j--) {
                    if (board[i][j] == 0) continue;
                    moved |= moveBlock(board, i, j, 0, 1);
                }
            }
        }
        
        return moved;
    }
    
    static boolean moveBlock(int[][] board, int r, int c, int dr, int dc) {
        boolean moved = false;
        int nr = r;
        int nc = c;
        
        while (true) {
            int nextR = nr + dr;
            int nextC = nc + dc;
            
            if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N) break;
            
            if (board[nextR][nextC] == 0) {
                board[nextR][nextC] = board[nr][nc];
                board[nr][nc] = 0;
                nr = nextR;
                nc = nextC;
                moved = true;
            }
            else if (board[nextR][nextC] == board[nr][nc] && !merged[nextR][nextC]) {
                board[nextR][nextC] *= 2;
                maxBlock = Math.max(maxBlock, board[nextR][nextC]);
                board[nr][nc] = 0;
                merged[nextR][nextC] = true;
                moved = true;
                break;
            }
            else {
                break;
            }
        }
        
        return moved;
    }
}