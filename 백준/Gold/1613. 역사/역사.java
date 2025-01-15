import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            map[i][i] = true;
        }
        
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            map[a][b] = true;
        }

        for(int l = 0; l < n; l++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if (map[i][l] && map[l][j]) map[i][j] = true;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());

        for(int i = 0; i < s; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            if (map[a][b]) {
                bw.write("-1\n");
            } else if (map[b][a]) {
                bw.write("1\n");
            } else  {
                bw.write("0\n");
            }
        }
        
        bw.close();
    }
}