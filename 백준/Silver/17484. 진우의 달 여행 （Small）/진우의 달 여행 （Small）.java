import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int MIN;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        MIN = Integer.MAX_VALUE;
        for(int i = 0; i < M; i++) {
            search(i, 0, arr[0][i], 2);
        }
        bw.write(MIN + "");
        bw.close();
    }
    static void search(int x, int y, int sum, int dir) {
        if(y >= N - 1) {
            if(sum < MIN)
                MIN = sum;
            return;
        }
        if(dir != 0)
        	search(x, y + 1, sum + arr[y + 1][x], 0);
        if(x != 0 && dir != -1)
            search(x - 1, y + 1, sum + arr[y + 1][x - 1], -1);
        if(x != M - 1 && dir != 1)
            search(x + 1, y + 1, sum + arr[y + 1][x + 1], 1);
    }
}