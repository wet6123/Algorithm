import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(map[i], (int)1e9);
            map[i][i] = 0;
        }
        
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            map[a][b] = Math.min(map[a][b], c);
        }

        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if (map[i][j] > map[i][k] + map[k][j])
                        map[i][j] = map[i][k] + map[k][j];
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (map[i][j] == (int)1e9)
                    bw.write("0 ");
                else
                    bw.write(map[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.close();
    }
}