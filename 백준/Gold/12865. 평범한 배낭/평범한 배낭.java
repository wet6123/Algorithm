import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[][] sum = new int[N+1][K+1];
        int[][] product = new int[N][2];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            product[i][0] = Integer.parseInt(st.nextToken());
            product[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i <= N; i++) {
            for(int j = 0; j <= K; j++) {
                sum[i][j] = 0;
            }
        }
        for(int i = 1; i <= N; i++) {
            int weight = product[i-1][0];
            int value = product[i-1][1];
            for(int j = 1; j <= K; j++) {
                if(weight <= j) {
                    sum[i][j] = Math.max(sum[i-1][j-weight] + value, sum[i-1][j]);
                } else {
                    sum[i][j] = sum[i-1][j];
                }
            }
        }
        bw.write(sum[N][K] + "");
        bw.close();
    }
}