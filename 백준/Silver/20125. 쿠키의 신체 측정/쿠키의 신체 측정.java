import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][N];
        
        int h_y = 0;
        int h_x = 0;
        int y = 0;
        int x = 0;
        int l_arm = 0;
        int r_arm = 0;
        int waist = 0;
        int l_leg = 0;
        int r_leg = 0;
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        
        all:for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == '*') {
                    h_y = i + 2;
                    h_x = j + 1;
                    y = i + 1;
                    x = j;
                    break all;
                }
            }
        }
        
        for(int i = x - 1; i >= 0; i--) {
            if(map[y][i] == '*') {
                l_arm++;
            } else {
                break;
            }
        }
        
        for(int i = x + 1; i < N; i++) {
            if(map[y][i] == '*') {
                r_arm++;
            } else {
                break;
            }
        }
        
        for(int i = y + 1; i < N; i++) {
            if(map[i][x] == '*') {
                waist++;
            } else {
                break;
            }
        }
        
        for(int i = y + waist + 1; i < N; i++) {
            if(map[i][x - 1] == '*') {
                l_leg++;
            } else {
                break;
            }
        }
        
        for(int i = y + waist + 1; i < N; i++) {
            if(map[i][x + 1] == '*') {
                r_leg++;
            } else {
                break;
            }
        }
        
        bw.write(h_y + " " + h_x + "\n");
        bw.write(l_arm + " " + r_arm + " " + waist + " " + l_leg + " " + r_leg);
        bw.close();
    }
}