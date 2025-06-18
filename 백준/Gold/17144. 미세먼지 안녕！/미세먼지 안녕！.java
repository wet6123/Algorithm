import java.io.*;
import java.util.*;

public class Main {
    static int R, C, T;
    static int[][] room;
    static int top, bottom;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        
        room = new int[R][C];
        
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if (room[i][j] == -1) {
                    if (top == 0) {
                        top = i;
                    } else {
                        bottom = i;
                    }
                }
            }
        }
        
        for (int time = 0; time < T; time++) {
            spreadDust();
            operateAirCleaner();
        }
        
        int totalDust = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (room[i][j] > 0) {
                    totalDust += room[i][j];
                }
            }
        }
        
        bw.write(totalDust + "");
        bw.close();
    }
    
    static void spreadDust() {
        int[][] newRoom = new int[R][C];
        
        newRoom[top][0] = -1;
        newRoom[bottom][0] = -1;
        
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (room[r][c] > 0) {
                    int dust = room[r][c];
                    int spreadAmount = dust / 5;
                    int spreadCount = 0;
                    
                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        
                        if (nr >= 0 && nr < R && nc >= 0 && nc < C && room[nr][nc] != -1) {
                            newRoom[nr][nc] += spreadAmount;
                            spreadCount++;
                        }
                    }
                    
                    newRoom[r][c] += dust - (spreadAmount * spreadCount);
                }
            }
        }
        
        room = newRoom;
        room[top][0] = -1;
        room[bottom][0] = -1;
    }
    
    static void operateAirCleaner() {
        operateTopAirCleaner();
        operateBottomAirCleaner();
    }
    
    static void operateTopAirCleaner() {        
        for (int r = top - 1; r > 0; r--) {
            room[r][0] = room[r - 1][0];
        }
        
        for (int c = 0; c < C - 1; c++) {
            room[0][c] = room[0][c + 1];
        }
        
        for (int r = 0; r < top; r++) {
            room[r][C - 1] = room[r + 1][C - 1];
        }
        
        for (int c = C - 1; c > 1; c--) {
            room[top][c] = room[top][c - 1];
        }
        room[top][1] = 0;
    }
    
    static void operateBottomAirCleaner() {
        for (int r = bottom + 1; r < R - 1; r++) {
            room[r][0] = room[r + 1][0];
        }
        
        for (int c = 0; c < C - 1; c++) {
            room[R - 1][c] = room[R - 1][c + 1];
        }
        
        for (int r = R - 1; r > bottom; r--) {
            room[r][C - 1] = room[r - 1][C - 1];
        }
        
        for (int c = C - 1; c > 1; c--) {
            room[bottom][c] = room[bottom][c - 1];
        }
        
        room[bottom][1] = 0;
    }
}