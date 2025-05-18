import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str1 = br.readLine();
        String str2 = br.readLine();
        
        int[][] dp = getLCSLength(str1, str2);
        int lcsLength = dp[str1.length()][str2.length()];
        
        bw.write(String.valueOf(lcsLength));
        bw.newLine();
        
        if (lcsLength > 0) {
            String lcs = getLCS(str1, str2, dp);
            bw.write(lcs);
            bw.newLine();
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static int[][] getLCSLength(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp;
    }
    
    public static String getLCS(String str1, String str2, int[][] dp) {
        int i = str1.length();
        int j = str2.length();
        StringBuilder lcs = new StringBuilder();
        
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                lcs.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        
        return lcs.reverse().toString();
    }
}