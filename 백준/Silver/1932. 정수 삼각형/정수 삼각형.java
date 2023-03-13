import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < i + 1; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
            }
        }
        
        for(int i = 1; i < N; i++) {
            for(int j = 0; j < i + 1; j++) {
                if (j > 0 && j < i) {
                    if (map[i - 1][j - 1] > map[i - 1][j]) {
                        map[i][j] += map[i - 1][j - 1];
                    } else {
                        map[i][j] += map[i - 1][j];
                    }
                } else if (j == 0) {
                	map[i][j] += map[i - 1][0];
                } else if (j == i){
                	map[i][j] += map[i - 1][i - 1];
                }
            }
        }
        
        int max = 0;
        
        for(int j = 0; j < N; j++) {
            if (max < map[N - 1][j]) {
                max = map[N - 1][j];
            }
        }
        bw.write(max + "");
        bw.close();
    }
}