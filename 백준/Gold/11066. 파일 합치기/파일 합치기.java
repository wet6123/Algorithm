import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
            int K = Integer.parseInt(br.readLine());
            int[] files = new int[K];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                files[i] = Integer.parseInt(st.nextToken());
            }
            
            // 이걸 생각 못함
            int[] prefixSum = new int[K + 1];
            for (int i = 0; i < K; i++) {
                prefixSum[i + 1] = prefixSum[i] + files[i];
            }
            
            int[][] dp = new int[K][K];
            
            for (int i = 0; i < K; i++) {
                dp[i][i] = 0;
            }
            
            for (int len = 2; len <= K; len++) {
                for (int i = 0; i <= K - len; i++) {
                    int j = i + len - 1;
                    dp[i][j] = Integer.MAX_VALUE;
                    
                    int sum = prefixSum[j + 1] - prefixSum[i];
                    
                    for (int k = i; k < j; k++) {
                        int cost = dp[i][k] + dp[k + 1][j] + sum;
                        dp[i][j] = Math.min(dp[i][j], cost);
                    }
                }
            }
            bw.write(dp[0][K - 1] + "\n");
        }
        bw.close();
    }
}